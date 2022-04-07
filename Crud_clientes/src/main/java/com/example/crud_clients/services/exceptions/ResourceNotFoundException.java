package com.example.crud_clients.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    private static final long SerialVersionUID = 1L;

    public ResourceNotFoundException(String message){
        super(message);
    }
}

// RuntimeException = não necessita de tratamento