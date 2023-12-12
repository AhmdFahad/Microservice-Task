package com.ahamdah.s2;

import com.ahamdah.s2.model.Status;
import com.ahamdah.s2.model.Transaction;
import com.ahamdah.s2.repository.TransactionRepository;
import com.ahamdah.s2.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class S2Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(S2Application.class, args);
    }

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void run(String... args) throws Exception {
//        Transaction x=Transaction.builder().
//                sender_id("1231131").
//                receiver_id("1534151").
//                amount(123.0d).
//                status(Status.PENDING).
//                build();
//        transactionRepository.save(x);
//        var b= transactionRepository.findAll();
//        b.forEach(System.out::println);
//        System.out.println("Systm is running");
//        var x=transactionRepository.findTransactionBySender_idNativeQuery("12795");
//        x.forEach(System.out::println);
//        var y =transactionRepository.findAllNative();
//        y.forEach(System.out::println);
//        System.out.println(y.size());
//
//
    }
}
