package com.ahamdah.s2;

import com.ahamdah.s2.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Service2Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Service2Application.class, args);
    }

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void run(String... args) throws Exception {

    }
}
