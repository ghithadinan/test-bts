package com.example.spring.test.bts.service;

import com.example.spring.test.bts.config.JwtService;
import com.example.spring.test.bts.helpers.Response;
import com.example.spring.test.bts.model.LoginRequestModel;
import com.example.spring.test.bts.model.ResponseModel;
import com.example.spring.test.bts.pojo.User;
import com.example.spring.test.bts.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepo repo;

    @Autowired
    JwtService jwtService;

    @Autowired
    PasswordEncoder encoder;

    public ResponseEntity<ResponseModel> login(LoginRequestModel req) {
        Optional<User> data = repo.findByUsername(req.getUsername());
        if (data.isPresent()) {
            if (encoder.matches(req.getPassword(), data.get().getPassword())) {
                return Response.success(jwtService.generateToken(data.get().getUsername()));
            }
        }
        return Response.forbidden();
    }

    public ResponseEntity<ResponseModel> register(User req) {
        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword(encoder.encode(req.getPassword()));
        user.setEmail(req.getEmail());
        repo.save(user);
        return Response.created(user);
    }
}
