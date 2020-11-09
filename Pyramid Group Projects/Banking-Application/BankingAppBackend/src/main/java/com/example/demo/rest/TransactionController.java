package com.example.demo.rest;

import com.example.demo.dao.TransactionDAOImpl;
import com.example.demo.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class TransactionController {
    private final TransactionDAOImpl transactionDAOImpl;

    @Autowired
    public TransactionController(TransactionDAOImpl transactionDAOImpl){
        this.transactionDAOImpl = transactionDAOImpl;
    }

    @GetMapping("/getTransaction/{id}")
    public Transaction findById(@PathVariable int id){
        return transactionDAOImpl.findTransactionById(id);
    }

    //http://localhost:8080/getAllTransaction/1
    @GetMapping("/getAllTransaction/{userID}")
    public List<Transaction> findAllByUserId(@PathVariable int userID){
        return transactionDAOImpl.findAllTransactionsByUserID(userID);
    }

    //http://localhost:8080/addTransaction
    @PostMapping("/addTransaction")
    public Transaction addTransaction(@RequestBody Transaction transaction){
        transaction.setId(0);

        Date date = new Date(System.currentTimeMillis());
        transaction.setDate(date);
        transactionDAOImpl.save(transaction);
        return transaction;
    }

    @DeleteMapping("/deleteTransaction/{id}")
    public String deleteTransaction(@PathVariable int id){
        Transaction transaction = transactionDAOImpl.findTransactionById(id);

        if(transaction == null) {
            throw new RuntimeException("Transaction is not found : " + id);
        }

        transactionDAOImpl.deleteByID(id);
        return "Deleted Transaction id: " + id;
    }
}
