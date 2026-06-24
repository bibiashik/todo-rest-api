package com.java.RestApiBasic.repository;

import com.java.RestApiBasic.entity.UserEntity;
import com.java.RestApiBasic.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByEmail(String email);



}
