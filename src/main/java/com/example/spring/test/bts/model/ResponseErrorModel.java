package com.example.spring.test.bts.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseErrorModel {

    private String key;

    private String message;

    public ResponseErrorModel(String key, String value) {
        this.key = key;
        this.message = value;
    }
}
