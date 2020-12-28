package com.andrew.nsimbi.transactionservice.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Component
@ConfigurationProperties("transaction-service")
public class Configuration {
    private int minimum;
    private int maximum;
}
