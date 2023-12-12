package com.example.service1;

import com.example.service1.model.Status;
import com.example.service1.model.Transaction;
import com.example.service1.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner{
    
    Logger logger= LoggerFactory.getLogger(Runner.class);

    private final List<String> userId=Arrays.asList("183946","105837","195639","195639","149274","195743");


    private final TransactionRepository transactionRepository;
    @Override
    public void run(String... args) throws Exception {
        logger.info("System Start");
    }

    @Scheduled(fixedRate = 2000)
    public void generateAndSaveRandomTransaction() {
        String senderId = getRandomUserId();
        String receiverId = getRandomUserId();

        while (senderId.equals(receiverId)) {
            receiverId = getRandomUserId();
        }

        double amount = random.nextDouble() * 10000; // Generate random amount
        amount =Double.parseDouble(new DecimalFormat("#.###").format(amount));
        Transaction transaction = Transaction.builder()
                .sender_id(senderId)
                .receiver_id(receiverId)
                .amount(amount)
                .status((random.nextBoolean())?Status.APPROVED:Status.PENDING)
                .build();
        transactionRepository.save(transaction);
        logger.info("new Transaction:"+transaction.toString());
    }
    private final Random random = new Random();

    private String getRandomUserId() {
        int index = random.nextInt(userId.size());
        return userId.get(index);
    }
}
