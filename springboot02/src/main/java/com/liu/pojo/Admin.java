package com.liu.pojo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "lv_admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;


}