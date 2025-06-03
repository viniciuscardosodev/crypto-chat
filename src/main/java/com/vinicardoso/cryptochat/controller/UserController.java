package com.vinicardoso.cryptochat.controller;

import com.vinicardoso.cryptochat.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    @GetMapping("/user")
    public ResponseEntity<UserEntity> getUser(@RequestParam String username) {
        var user = UserEntity.getUser(username);
        if (user != null) {
            System.out.println(user);
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/signIn")
    public ResponseEntity<UserEntity> postUser(@RequestBody UserEntity user) {
        System.out.println(user);
        if (UserEntity.alreadyRegistered(user.getUsername()))
            return ResponseEntity.unprocessableEntity().build();
        else {
            user.persist();
            return ResponseEntity.ok(user);
        }
    }

}
