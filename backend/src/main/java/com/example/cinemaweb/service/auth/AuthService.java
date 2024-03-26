package com.example.cinemaweb.service.auth;

import com.example.cinemaweb.dto.AuthRequest;
import com.example.cinemaweb.dto.SignupRequest;
import com.example.cinemaweb.dto.UserView;

public interface AuthService {

    public UserView login(AuthRequest authRequest);
    public UserView createUser(SignupRequest signupRequest);
    public boolean hasUserWithEmail(String email);

}
