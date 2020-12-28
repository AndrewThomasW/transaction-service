package com.andrew.nsimbi.transactionservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;
    private Long toPhoneNumber;
    private BigDecimal amount;
    private LocalDate creationDate;
    private LocalDate updateDate;
    private TransactionStatus status;
    private String failMessage;


    // How do we assign a unique transaction ID?  Find Out how??
    public Transaction(String email, Long toPhoneNumber, BigDecimal amount, LocalDate creationDate, LocalDate updateDate, TransactionStatus status, String failMessage  ) {
        this.email = email;
        this.toPhoneNumber = toPhoneNumber;
        this.amount = amount;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.status =status;
        this.failMessage = failMessage;
    }

}
