package com.example.cinemaweb.entity;

import java.util.*;

import com.example.cinemaweb.dto.UserView;
import com.example.cinemaweb.enums.UserRole;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tbluser")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_password")
    private String password;
    @Column(name = "user_fullname")
    private String fullname;
    @Column(name = "user_birthday")
    private Date birthday;
    @Column(name = "user_gender")
    private String gender;
    @Column(name = "user_phone")
    private String phoneNumber;
    @Column(name = "user_deleted", columnDefinition = "BIT(1) DEFAULT 0")
    private boolean deleted;
    @Column(name = "user_active", columnDefinition = "BIT(1) DEFAULT 0")
    private boolean active;
    @Column(name = "user_created_at")
    private Date createdAt;
    @Column(name = "user_modified_at")
    private Date modifiedAt;
    @Column(name = "user_role")
    private UserRole role;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<RefreshToken> refreshTokens;

    public UserView getUserView() {
        UserView user = new UserView();
        user.setId(id);
        user.setEmail(email);
        user.setFullname(fullname);
        user.setBirthday(birthday);
        user.setGender(gender);
        user.setPhoneNumber(phoneNumber);
        user.setActive(active);
        user.setDeleted(deleted);
        user.setCreatedAt(createdAt);
        user.setModifiedAt(modifiedAt);
        user.setRole(role);
        return user;
    }

}
