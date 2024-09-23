package com.jobconnect.exception;

public class ApplicationNotFoundException extends ResourceNotFoundException {
    public ApplicationNotFoundException(String message) {
        super(message);
    }
}

