package com.andrew.nsimbi.transactionservice.service;

import com.andrew.nsimbi.transactionservice.exception.NoSuchResourceException;
import com.andrew.nsimbi.transactionservice.model.Transaction;

import java.util.List;

public interface TransactionService {
    public Transaction addTransaction(Transaction transaction);

    public Transaction getTransaction(long transactionId) throws NoSuchResourceException;

    public List<Transaction> getTransactions();

    public Transaction editTransaction(long transactionID, Transaction edit_transaction) throws NoSuchResourceException;

    public Transaction deleteTransaction(long transactionId) throws NoSuchResourceException;
}
