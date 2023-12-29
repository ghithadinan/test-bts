package com.example.spring.test.bts.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "users", schema = "public")
public class User {

    @Id
    @Column(name = "id")
    private String id = UUID.randomUUID().toString();

    @Column(name = "username")
    @NotEmpty(message = "Username required")
    private String username;

    @JsonIgnore
    @Column(name = "password")
    @NotEmpty(message = "Password required")
    private String password;

    @Column(name = "email")
    @NotEmpty(message = "Email required")
    private String email;
}
