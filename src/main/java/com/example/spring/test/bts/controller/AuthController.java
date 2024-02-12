package com.example.spring.test.bts.controller;

import com.example.spring.test.bts.model.LoginRequestModel;
import com.example.spring.test.bts.model.ResponseModel;
import com.example.spring.test.bts.pojo.User;
import com.example.spring.test.bts.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("")
public class AuthController {

    @Autowired
    AuthService service;

    @PostMapping("login")
    public ResponseEntity<ResponseModel> login(@Valid @RequestBody LoginRequestModel req) {
        return service.login(req);
    }

    @PostMapping("register")
    public ResponseEntity<ResponseModel> register(@Valid @RequestBody User req) {
        return service.register(req);
    }
}
