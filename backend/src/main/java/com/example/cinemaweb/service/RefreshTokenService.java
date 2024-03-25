package com.example.cinemaweb.service;

import java.util.Optional;

import com.example.cinemaweb.entity.RefreshToken;

public interface RefreshTokenService {

    public Optional<RefreshToken> findByToken(String token);
    public RefreshToken createdRefreshToken(String username);
    public RefreshToken verifyToken(RefreshToken token);
    public int deleteByUserId(int userId);

}
