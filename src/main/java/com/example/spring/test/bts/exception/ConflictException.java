package com.example.spring.test.bts.exception;

public class ConflictException extends BaseException {

    public ConflictException() {
        this.setMessage("Conflict");
    }

    public ConflictException(String message) {
        this.setMessage(message);
    }
}
