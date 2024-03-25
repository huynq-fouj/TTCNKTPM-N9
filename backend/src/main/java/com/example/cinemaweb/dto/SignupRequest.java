package com.example.cinemaweb.dto;

import lombok.Data;

@Data
public class SignupRequest {

    private String username;
    private String email;
    private String fullname;
    private String password;
    private String confirm;

}
