package com.ahamdah.s2.controller;

import com.ahamdah.s2.exception.NotFoundException;
import com.ahamdah.s2.model.Transaction;
import com.ahamdah.s2.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping(value = "/page/{pageNumber}")
    public Page<Transaction> pagenation(@PathVariable int pageNumber, @RequestParam(name = "size",defaultValue ="5",required = false) int size){
        return transactionService.pagableTransaction(pageNumber,size);
    }
    @GetMapping(value = "/filter",params = {"a1","a2"})
    public List<Transaction> getTransactionAmmountBetween(@RequestParam double a1,@RequestParam double a2){
        return transactionService.ammountBetween(a1,a2);
    }
    @GetMapping("/sort")
    public List<Transaction> sorting(@RequestParam(required = false,defaultValue = "amount") String sort,@RequestParam(required = false,defaultValue = "ASC") String direction){
        return transactionService.transactionsSorting(sort,direction.toUpperCase());
    }
    @GetMapping("/num")
    public int getNumber() {
        return transactionService.getTransactionNumber();
    }
    @GetMapping("/max")
    public String getMax() {
        return transactionService.getMaxAmount();
    }
    @GetMapping("/min")
    public String getMin() {
        return transactionService.getMinAmount();
    }


}
