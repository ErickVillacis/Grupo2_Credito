package com.banquito.core.banking.creditos.utils;

public class ValidacionException extends RuntimeException {

    public ValidacionException(String message) {
        super("Valor incorrecto en " + message);
    }
}
