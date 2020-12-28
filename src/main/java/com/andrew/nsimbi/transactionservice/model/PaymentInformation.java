package com.andrew.nsimbi.transactionservice.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
public class PaymentInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String cardNumber;
    private int expirydateDay;
    private int expirydateMonth;
    private int csv;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Address address;

    //to be used as primary key Account Id
    private BigDecimal accountNumber;

    public PaymentInformation(String cardNumber, int expirydateDay, int expirydateMonth, int csv) {
        this.cardNumber = cardNumber;
        this.expirydateDay = expirydateDay;
        this.expirydateMonth = expirydateMonth;
        this.csv = csv;
    }
}
