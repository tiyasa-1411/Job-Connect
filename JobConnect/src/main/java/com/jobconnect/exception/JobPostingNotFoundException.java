package com.jobconnect.exception;

public class JobPostingNotFoundException extends ResourceNotFoundException {
    public JobPostingNotFoundException(String message) {
        super(message);
    }
}

