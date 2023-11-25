package com.example.spring.test.bts.exception;

public class UnsupportedMediaTypeException extends BaseException {

    public UnsupportedMediaTypeException() {
        this.setMessage("Unsuported Media Type");
    }

    public UnsupportedMediaTypeException(String message) {
        this.setMessage(message);
    }
}
