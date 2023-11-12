package com.JWTexample.service.jwt;

import com.JWTexample.entity.UserInfo;
import com.JWTexample.userRepo.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserinfoServiceimpl implements UserDetailsService {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Override
    public  UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserInfo userinfo = userInfoRepository.findFirstByEmail(email);
        if(userinfo == null){
            throw new UsernameNotFoundException("not found");
        }
        return new org.springframework.security.core.userdetails.User(userinfo.getEmail(),userinfo.getPassword(),new ArrayList<>());
    }
}
