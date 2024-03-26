package com.example.cinemaweb.dto;

import java.util.Date;

import lombok.Data;

@Data
public class SignupRequest {
    private String fullname;
    private String email;
    private String password;
    private String confirm;
    private Date birthday;
    private String gender;
    private String phoneNumber;
}
