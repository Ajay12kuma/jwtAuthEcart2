package com.JWTexample.dto;

import lombok.Data;

@Data
public class SignUpReq {
    private String name;
    private String email;
    private String phone;
    private String password;
}
