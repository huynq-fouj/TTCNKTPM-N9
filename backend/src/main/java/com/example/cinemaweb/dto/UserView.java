package com.example.cinemaweb.dto;

import java.util.*;

import com.example.cinemaweb.enums.UserRole;

import lombok.Data;

@Data
public class UserView {
    private int id;
    private String email;
    private String fullname;
    private String gender;
    private Date birthday;
    private String phoneNumber;
    private boolean deleted;
    private boolean active;
    private Date createdAt;
    private Date modifiedAt;
    private UserRole role;
}
