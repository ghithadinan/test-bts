package com.example.spring.test.bts.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestModel {

    @NotEmpty(message = "Username required")
    private String username;

    @NotEmpty(message = "Password required")
    private String password;


}
