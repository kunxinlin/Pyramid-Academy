package com.example.demo.dao;

import com.example.demo.entity.Transaction;

import java.util.List;

public interface TransactionDAO {
    Transaction findTransactionById(int id);
    List<Transaction> findAllTransactionsByUserID(int id);
    void save(Transaction transaction);
    void deleteByID(int id);
}
