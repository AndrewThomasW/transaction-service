package com.andrew.nsimbi.transactionservice.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoSuchResourceException extends Throwable {
    private String message;
    private long resouceId;

    public NoSuchResourceException(String message, long resouceId) {
        super();
        this.message = message;
        this.resouceId = resouceId;
    }

}
