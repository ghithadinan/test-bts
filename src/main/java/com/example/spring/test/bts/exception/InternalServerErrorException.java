package com.example.spring.test.bts.exception;

public class InternalServerErrorException extends BaseException {

    public InternalServerErrorException() {
        this.setMessage("Internal Server Error");
    }

    public InternalServerErrorException(String message) {
        this.setMessage(message);
    }
}
