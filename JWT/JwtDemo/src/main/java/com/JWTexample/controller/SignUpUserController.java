package com.JWTexample.controller;

import com.JWTexample.dto.SignUpReq;
import com.JWTexample.dto.UserDTO;
import com.JWTexample.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpUserController {
    @Autowired
    private AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody SignUpReq signUpReq){
        UserDTO createUser = authService.createUser(signUpReq);
        if(createUser == null){
            return new ResponseEntity<>("user didnt created", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("user created", HttpStatus.CREATED);
    }

}
