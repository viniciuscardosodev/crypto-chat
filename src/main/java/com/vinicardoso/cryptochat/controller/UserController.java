package com.vinicardoso.cryptochat.controller;

import com.vinicardoso.cryptochat.entity.UserEntity;
import com.vinicardoso.cryptochat.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserEntity> login(@RequestBody UserEntity user) {
        var possibleUser = userService.findLogin(user.getUsername(), user.getPassword());
        return possibleUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
