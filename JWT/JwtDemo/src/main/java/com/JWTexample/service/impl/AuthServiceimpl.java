package com.JWTexample.service.impl;

import com.JWTexample.dto.SignUpReq;
import com.JWTexample.dto.UserDTO;
import com.JWTexample.entity.UserInfo;
import com.JWTexample.service.AuthService;
import com.JWTexample.userRepo.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceimpl implements AuthService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserDTO createUser(SignUpReq signUpReq) {
        UserInfo user = new UserInfo();
        user.setEmail(signUpReq.getEmail());
        user.setName(signUpReq.getName());
        user.setPhone(signUpReq.getPhone());
        user.setPassword(new BCryptPasswordEncoder().encode(signUpReq.getPassword()));
        UserInfo createdUser = this.userInfoRepository.save(user);
        UserDTO userdto = new UserDTO();
        userdto.setName(createdUser.getName());
        userdto.setPhone(createdUser.getPhone());
        userdto.setEmail(createdUser.getEmail());
        return userdto;
    }
}
