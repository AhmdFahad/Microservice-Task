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

    @GetMapping(value = {"","/"})
    public List<Transaction> getAll(){
        return transactionService.getAll();
    }

    @GetMapping("/{id}")
    public Transaction getById(@PathVariable String id) throws NotFoundException {
        return transactionService.getTransaction(id);
    }
    @GetMapping(value = "/{pageNumber}",params = {"size"})//   /pageNumber?size=1
    public Page<Transaction> pagenation(@PathVariable int pageNumber, @RequestParam(name = "size",defaultValue ="5",required = false) int size){
        return transactionService.pagableTransaction(pageNumber,size);
    }



    //params ={"size"}
    @GetMapping("/num")
    public int getNumber() {
        return transactionService.getTransactionNumber();
    }

    @DeleteMapping("/{id}")
    public Transaction deleteById(@PathVariable String id) throws NotFoundException {
        return transactionService.deleteTransaction(id);
    }
    @DeleteMapping("/")
    public ResponseEntity<String> deleteALL(){
        transactionService.deleteAll();
        return new ResponseEntity<>("delete All Transaction",HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction){
        var x =transactionService.create(transaction);
        return new ResponseEntity<>(x,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String>updateTransaction(@PathVariable String id,@RequestBody Transaction transaction) throws NotFoundException{
        transactionService.update(id ,transaction);
        return  new ResponseEntity<>("Transaction update it",HttpStatus.OK);
    }

    @GetMapping("/sort")
    public List<Transaction> sorting(@RequestParam(required = false,defaultValue = "amount") String sort,@RequestParam(required = false,defaultValue = "ASC") String direction){
        return transactionService.transactionsSorting(sort,direction.toUpperCase());
    }

}
