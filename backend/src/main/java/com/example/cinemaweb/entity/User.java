package com.example.cinemaweb.entity;

import java.util.*;

import org.hibernate.annotations.DialectOverride.GeneratedColumn;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    @Column(name = "user_name")
    private String username;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_password")
    private String password;
    @Column(name = "user_fullname")
    private String fullname;
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
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<RefreshToken> refreshTokens;

}
