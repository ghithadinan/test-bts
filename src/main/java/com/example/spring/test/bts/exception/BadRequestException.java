package com.example.spring.test.bts.exception;

public class BadRequestException extends BaseException {

    public BadRequestException() {
        this.setMessage("Bad Request");
    }

    public BadRequestException(String message) {
        this.setMessage(message);
    }
}
