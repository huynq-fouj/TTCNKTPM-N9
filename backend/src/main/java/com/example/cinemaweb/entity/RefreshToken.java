package com.example.cinemaweb.entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tblrefreshtoken")
public class RefreshToken {

    @Id
    @Column(name = "rt_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "rt_token")
    private String token;
    @Column(name = "rt_expried_time")
    private Date expriedTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rt_user_id", referencedColumnName = "user_id")
    private User user;

}
