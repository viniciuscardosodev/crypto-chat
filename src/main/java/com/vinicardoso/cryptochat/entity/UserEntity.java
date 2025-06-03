package com.vinicardoso.cryptochat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserEntity {

    public static HashMap<String, UserEntity> users = new HashMap<>();

    private String username;
    private int[][] keyMatrix;

    public static UserEntity getUser(String username) {
        return users.get(username);
    }

    public static boolean alreadyRegistered(String username) {
        return users.containsKey(username);
    }

    public void persist(){
        users.put(username, this);
    }

}
