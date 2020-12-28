package com.andrew.nsimbi.transactionservice.controller;

import com.andrew.nsimbi.transactionservice.exception.NoSuchResourceException;
import com.andrew.nsimbi.transactionservice.feignProxy.PaymentProxy;
import com.andrew.nsimbi.transactionservice.model.Transaction;
import com.andrew.nsimbi.transactionservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @Autowired
    PaymentProxy paymentProxy;

    @PostMapping(value = "/")
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction) {

        //get accountNumber PaymentInformation

        //check if the account has enough from stripe

        //get money from customers account to Nsimbi account

        //getmoney from Nsimbi account(UGX) to respective mobile money number



        HttpHeaders headers = new HttpHeaders();

        if (transaction == null) {
            return new ResponseEntity<Transaction>(HttpStatus.BAD_REQUEST);
        }
        transactionService.addTransaction(transaction);

        // headers.add("Transaction added :", transaction.);

        return new ResponseEntity<Transaction>(transaction, headers, HttpStatus.CREATED);

    }

    // ResponseEntity<List<Transaction>>
    //
    @GetMapping(value = "/")
    public ResponseEntity<List<Transaction>> getTransactions()  {

        //System.out.println(paymentProxy.getPaymentInformation(2));

        HttpHeaders headers = new HttpHeaders();

        List<Transaction> transactions = transactionService.getTransactions();
        if (transactions == null) {
            return new ResponseEntity<List<Transaction>>(HttpStatus.NOT_FOUND);
        }
//        headers.add("Number of Blocks returned", String.valueOf(transactions.size()));

        return new ResponseEntity<List<Transaction>>(transactions, headers, HttpStatus.OK);

    }

    @GetMapping(value = "/{transactionId}")
    public ResponseEntity<Transaction> getTransaction(@PathVariable long transactionId) throws NoSuchResourceException {

        Transaction transaction = transactionService.getTransaction(transactionId);

        if (transaction == null) {

            return new ResponseEntity<Transaction>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Transaction> editAccount(@RequestBody Transaction transaction) throws NoSuchResourceException {

        HttpHeaders headers = new HttpHeaders();
        Transaction transaction_toEdit = transactionService.getTransaction(transaction.getId());

        if (transaction_toEdit == null) {

            return new ResponseEntity<Transaction>(HttpStatus.NOT_FOUND);
        }

        Transaction updatedTransaction = transactionService.editTransaction(transaction.getId(), transaction);

//        headers.add("Updated Block : ", String.valueOf(transaction.getId()));

        return new ResponseEntity<Transaction>(updatedTransaction, headers, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{transactionId}")
    public Transaction deleteTransaction(@PathVariable long transactionId) throws NoSuchResourceException {

        return transactionService.deleteTransaction(transactionId);

    }

}
