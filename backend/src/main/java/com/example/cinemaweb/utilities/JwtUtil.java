package com.example.cinemaweb.utilities;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    @Value("${jwt.secret.key}")
    private String JWT_SECRET;
    @Value("${jwt.access.expire}")
    private long JWT_EXP_ACCESS;
    @Value("${jwt.refresh.expire}")
    private long JWT_EXP_REFRESH;

    public String generateAccessToken(String userName) {
        
        return createToken(userName, JWT_EXP_ACCESS);
    }

    public String generateRefreshToken(String userName) {
        return createToken(userName, JWT_EXP_REFRESH);
    }

    private String createToken(String userName, long expiryDate) {

        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder()
                .subject(userName)
                .claims().add(claims).and()
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiryDate))
                .signWith(getSignKey(), Jwts.SIG.HS256)
                .compact();
    }

    private SecretKey getSignKey() {
        byte[] keyByte = Decoders.BASE64.decode(this.JWT_SECRET);
        return Keys.hmacShaKeyFor(keyByte);
    }

     public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().verifyWith(getSignKey()).build().parseSignedClaims(token).getPayload();
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

}
