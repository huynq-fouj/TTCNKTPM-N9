package com.example.cinemaweb.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String fullname;
    private String email;
    private String password;
    private String confirm;
    private String phoneNumber;
}
