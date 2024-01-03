package com.banquito.core.banking.creditos.utils;

public class TransaccionException extends RuntimeException {

    public TransaccionException(String message) {
        super(message);
    }

    public TransaccionException(String message, Exception cause) {
        super(message, cause);
    }
}
