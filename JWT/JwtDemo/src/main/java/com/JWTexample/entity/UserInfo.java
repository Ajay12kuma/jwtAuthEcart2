package com.JWTexample.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="user_info_t")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String phone;
    private String password;
    //private String roles;

}
