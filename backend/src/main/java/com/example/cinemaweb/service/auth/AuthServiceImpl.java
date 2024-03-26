package com.example.cinemaweb.service.auth;

import java.util.Date;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.cinemaweb.dto.AuthRequest;
import com.example.cinemaweb.dto.SignupRequest;
import com.example.cinemaweb.dto.UserView;
import com.example.cinemaweb.entity.User;
import com.example.cinemaweb.enums.UserRole;
import com.example.cinemaweb.repository.UserRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserView login(AuthRequest authRequest) {
        return null;
    }

    @Override
    public UserView createUser(SignupRequest signupRequest) {
        User user = new User();
        user.setEmail(signupRequest.getEmail());
        user.setFullname(signupRequest.getFullname());
        user.setPassword(this.bCryptPasswordEncoder.encode(signupRequest.getPassword()));
        user.setGender(signupRequest.getGender());
        user.setBirthday(signupRequest.getBirthday());
        user.setPhoneNumber(signupRequest.getPhoneNumber());
        user.setCreatedAt(new Date());
        user.setModifiedAt(new Date());
        user.setDeleted(false);
        user.setActive(true);
        user.setRole(UserRole.USER);
        User createdUser = this.userRepository.save(user);
        return createdUser.getUserView();
    }

    @Override
    public boolean hasUserWithEmail(String email) {
        return this.userRepository.findFirstByEmail(email).isPresent();
    }

    @PostConstruct
    public void createAdminAccount() {
        User adminAccount = userRepository.findByRole(UserRole.ADMIN);
        if(adminAccount == null) {
            User user = new User();
            user.setEmail("admin@test.com");
            user.setFullname("Admin");
            user.setRole(UserRole.ADMIN);
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(user);
        }
    }
    
}
