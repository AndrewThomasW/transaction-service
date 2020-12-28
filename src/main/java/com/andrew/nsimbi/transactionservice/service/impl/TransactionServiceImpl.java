package com.andrew.nsimbi.transactionservice.service.impl;

import com.andrew.nsimbi.transactionservice.exception.NoSuchResourceException;
import com.andrew.nsimbi.transactionservice.model.Transaction;
import com.andrew.nsimbi.transactionservice.repository.TransactionRepository;
import com.andrew.nsimbi.transactionservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Transaction addTransaction(Transaction transaction) {

        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction getTransaction(long transactionId) throws NoSuchResourceException {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new NoSuchResourceException("No Transaction found  with", transactionId));

        return transaction;
    }

    @Override
    public List<Transaction> getTransactions() {

        return transactionRepository.findAll();
    }

    @Override
    public Transaction editTransaction(long transactionID, Transaction edit_transaction) throws NoSuchResourceException {

        Transaction transaction = transactionRepository.findById(transactionID)
                .orElseThrow(() -> new NoSuchResourceException("No transaction found  with", transactionID));

        transaction.setAmount(edit_transaction.getAmount());
        transaction.setCreationDate(edit_transaction.getCreationDate());

        transaction.setFailMessage(edit_transaction.getFailMessage());


        transaction.setStatus(edit_transaction.getStatus());
        transaction.setUpdateDate(edit_transaction.getUpdateDate());

        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction deleteTransaction(long transactionID) throws NoSuchResourceException {
        Transaction transaction = transactionRepository.findById(transactionID)
                .orElseThrow(() -> new NoSuchResourceException("No Transaction found  with", transactionID));

        transactionRepository.save(transaction);

        return transactionRepository.save(transaction);
    }

    // Emad --- update for order operations
}
