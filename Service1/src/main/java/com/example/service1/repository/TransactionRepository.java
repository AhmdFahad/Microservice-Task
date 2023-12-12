package com.example.service1.repository;

import com.example.service1.model.Transaction;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TransactionRepository extends ElasticsearchRepository<Transaction,String > {

}
