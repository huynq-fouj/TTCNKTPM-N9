package com.example.cinemaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cinemaweb.entity.RefreshToken;
import java.util.Optional;
import com.example.cinemaweb.entity.User;



@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Integer> {

    Optional<RefreshToken> findByToken(String token);
    int deleteByUser(User user);
}
