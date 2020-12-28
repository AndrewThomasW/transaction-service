package com.andrew.nsimbi.transactionservice.controller;


import com.andrew.nsimbi.transactionservice.configuration.Configuration;
import com.andrew.nsimbi.transactionservice.configuration.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private Configuration configuration;

    @GetMapping
    public String getMessage(){
        return "Nsimbi app - transaction service";
    }

    @GetMapping(value = "/config")
    public LimitConfiguration getConfigs(){
        return new LimitConfiguration(configuration.getMinimum(),configuration.getMaximum());
    }
}
