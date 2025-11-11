package com.pm.patientservice.exception;

public class EmailAlreadyExistsException extends Throwable {
    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
