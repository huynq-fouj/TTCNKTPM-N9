package com.example.cinemaweb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cinemaweb.dto.AuthRequest;
import com.example.cinemaweb.dto.RefreshTokenRequest;
import com.example.cinemaweb.dto.SignupRequest;
import com.example.cinemaweb.dto.UserView;
import com.example.cinemaweb.service.UserService;
import com.example.cinemaweb.service.auth.AuthService;
import com.example.cinemaweb.utilities.JwtUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private static final String TOKEN_PREFIX = "Bearer ";
    private static final String HEADER_STRING = "Authorization";
    private final AuthService authService; 
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        return null;
    }

    @PostMapping(path = "/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) {
        if(authService.hasUserWithEmail(signupRequest.getEmail())) {
            return new ResponseEntity<>("Email đã tồn tại!", HttpStatus.NOT_ACCEPTABLE);
        }
        UserView userView = authService.createUser(signupRequest);
        return new ResponseEntity<>(userView, HttpStatus.OK);
    }

    @PostMapping(path = "/refresh-token")
    public ResponseEntity<?> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return null;
    }

}
