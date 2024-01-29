package com.tweetero.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetero.api.dtos.UserDTO;
import com.tweetero.api.models.UserModel;
import com.tweetero.api.repositories.UserRepository;
import com.tweetero.api.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserCrontroller {

    final UserService userService;

    UserCrontroller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Object> getUsers(){
        List<UserModel> users = userService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserDTO body) {
        Optional<UserModel> user = userService.save(body);
        if (user.isEmpty()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Nome de usuário indisponivel!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    
}