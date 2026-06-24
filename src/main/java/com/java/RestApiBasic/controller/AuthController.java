package com.java.RestApiBasic.controller;

import com.java.RestApiBasic.entity.UserEntity;
import com.java.RestApiBasic.repository.UserRepository;
import com.java.RestApiBasic.service.UserService;
import com.java.RestApiBasic.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Map<String, String> body)
    {
        String email=body.get("email");
        String password=passwordEncoder.encode(body.get("password"));


        if(userRepository.findByEmail(email).isPresent()){
            return new  ResponseEntity<>("Email exists",HttpStatus.CONFLICT);
        }

        userService.createUser(UserEntity.builder().email(email).password(password).build());
        return new  ResponseEntity<>("created",HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> body)
    {
        String email=body.get("email");
        String password=body.get("password");

        var userOptional = userRepository.findByEmail(email);
        if(userOptional.isEmpty())
        {
            return new ResponseEntity<>("user not registered",HttpStatus.UNAUTHORIZED);
        }
        UserEntity user=userOptional.get();
        if(!passwordEncoder.matches(password,user.getPassword())){
            return new ResponseEntity<>("invalid password",HttpStatus.UNAUTHORIZED);
        }
        String token=jwtUtil.generateToken(email);
        return ResponseEntity.ok(Map.of("token",token));



    }

}
