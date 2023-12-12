package com.ahamdah.s2.repository;

import com.ahamdah.s2.model.Transaction;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface TransactionRepository extends ElasticsearchRepository<Transaction,String> {

    @Query("{\"match\": {\"sender_id\": {\"query\": \"?0\"}}}")
    Collection<Transaction> findTransactionBySender_idNativeQuery(String sender_id);
    @Query("{\"match\": {\"receiver_id\": {\"query\": \"?0\"}}}")
    Collection<Transaction> findTransactionByReceiver_idNativeQuery(String receiver_id);
    Collection<Transaction> queryByAmountBetweenOrderByAmount(double x1,double x2);
}

