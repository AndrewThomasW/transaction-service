package com.andrew.nsimbi.transactionservice.feignProxy;

import com.andrew.nsimbi.transactionservice.model.PaymentInformation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "payment-service", url = "http://localhost:8200/")
public interface PaymentProxy {
    @GetMapping(value = "/payment/{paymentInformationId}")
    public ResponseEntity<PaymentInformation> getPaymentInformation(@PathVariable long paymentInformationId);

}
