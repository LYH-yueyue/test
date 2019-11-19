package com.liu.pojo;

import lombok.Data;

import javax.persistence.*;

@Data //自动配置set, get, toString等方法
@Entity //注明实体类
@Table(name = "lv_user") //正向工程的时候配合Colunm, Id等标签自动在数据库生成表
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "userSex")
    private String sex;

    @Column(name = "userPhone")
    private Integer phone;

    @Column(name = "userIdCard")
    private Long IDcard;//身份证号码

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "collection_id")
    private LV_Collection collection;//单向关系关联收藏类
}
