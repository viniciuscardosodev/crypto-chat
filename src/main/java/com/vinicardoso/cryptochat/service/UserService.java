package com.vinicardoso.cryptochat.service;

import com.vinicardoso.cryptochat.entity.UserEntity;
import com.vinicardoso.cryptochat.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserEntity> findLogin(String username, String password) {
        return Optional.of(userRepository.findLogin(username, password));
    }

}
