package com.example.cinemaweb.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.cinemaweb.entity.RefreshToken;
import com.example.cinemaweb.exception.RefreshTokenException;
import com.example.cinemaweb.repository.RefreshTokenRepository;
import com.example.cinemaweb.repository.UserRepository;
import com.example.cinemaweb.utilities.JwtUtil;

@Service
public class RefreshTokenServiceImpl implements RefreshTokenService {

    @Value("${jwt.refresh.expire}")
    private long refreshTokenExpire;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    public RefreshToken createdRefreshToken(String username) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUser(userRepository.findFirstByEmail(username).get());
        refreshToken.setExpriedTime(new Date(System.currentTimeMillis() + refreshTokenExpire));
        refreshToken.setToken(jwtUtil.generateRefreshToken(username));
        refreshToken = refreshTokenRepository.save(refreshToken);
        return refreshToken;
    }

    public RefreshToken verifyToken(RefreshToken token) {
        if(token.getExpriedTime().before(new Date())) {
            refreshTokenRepository.delete(token);
            throw new RefreshTokenException(token.getToken(), "Phiên đăng nhập đã hết hạn. Vui lòng đăng nhập lại!");
        }
        return token;
    }

    @Transactional
    public int deleteByUserId(int userId) {
        return refreshTokenRepository.deleteByUser(userRepository.findById(userId).get());
    }

}
