package com.java.RestApiBasic.service;

import com.java.RestApiBasic.entity.UserEntity;
import com.java.RestApiBasic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);

    }

    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found " + id));
    }


    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }


    public UserEntity updateUser(UserEntity user) {
        return userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

}
