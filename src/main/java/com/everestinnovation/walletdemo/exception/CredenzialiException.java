package com.everestinnovation.walletdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CredenzialiException extends RuntimeException{
    public CredenzialiException(String message) { super(message);}
}
