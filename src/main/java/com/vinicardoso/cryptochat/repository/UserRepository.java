package com.vinicardoso.cryptochat.repository;

import com.vinicardoso.cryptochat.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    UserEntity findLogin(String username, String password);

}
