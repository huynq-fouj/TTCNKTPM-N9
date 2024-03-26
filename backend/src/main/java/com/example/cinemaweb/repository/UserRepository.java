package com.example.cinemaweb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cinemaweb.entity.User;
import com.example.cinemaweb.enums.UserRole;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findFirstByEmail(String email);

    User findByRole(UserRole admin);

}
