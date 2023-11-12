package com.JWTexample.service;

import com.JWTexample.dto.SignUpReq;
import com.JWTexample.dto.UserDTO;

public interface AuthService {
    UserDTO createUser(SignUpReq signUpReq);
}
