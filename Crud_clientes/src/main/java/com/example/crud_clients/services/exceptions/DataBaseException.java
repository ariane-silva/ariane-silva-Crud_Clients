package com.example.crud_clients.services.exceptions;

public class DataBaseException extends RuntimeException {
    private static final long SerialVersionUID = 1L;

    public DataBaseException(String message) {
        super(message);
    }
}
