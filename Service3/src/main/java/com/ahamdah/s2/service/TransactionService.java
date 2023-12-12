package com.ahamdah.s2.service;

import com.ahamdah.s2.client.AmountClient;
import com.ahamdah.s2.model.Transaction;
import com.ahamdah.s2.repository.TransactionRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import feign.Feign;
import feign.Target;
import jakarta.json.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final RestTemplate restTemplate;

    public Page<Transaction> pagableTransaction(int pageNumber, int size){
        Pageable pageable= PageRequest.of(pageNumber,size);
        return transactionRepository.findAll(pageable);
    }
    public List<Transaction> transactionsSorting(String sort,String d){
        var direction=Sort.Direction.DESC;
        if(!d.equals("DESC"))
            direction=Sort.Direction.ASC;
        List<Transaction> list=new ArrayList<>();
        var x=transactionRepository.findAll(Sort.by(direction,sort));
        x.forEach(list::add);
        return list;
    }
    public List<Transaction> ammountBetween(double a1, double a2){
        List<Transaction> list=new ArrayList<>();
        var x=transactionRepository.queryByAmountBetweenOrderByAmount(a1,a2);
        list.addAll(x);
        return list;
    }
    public int getTransactionNumber(){
        List<Transaction> list=new ArrayList<>();
        var x=transactionRepository.findAll();
        x.forEach(list::add);
        return list.size();
    }
    public String getMaxAmount(){
        return restTemplate.getForObject("http://localhost:5000/transaction/max", String.class);
    }
    public String getMinAmount(){
        return restTemplate.getForObject("http://localhost:5000/transaction/min", String.class);
    }
}
