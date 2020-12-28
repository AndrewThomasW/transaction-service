package com.andrew.nsimbi.transactionservice.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LimitConfiguration {
    private int minimum;
    private int maximum;
}
