package com.liu.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.GeneratorType;
import org.springframework.data.jpa.repository.Query;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Data
@Entity
@Table(name = "lv_hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //主键自增
    private Integer id;

    @Column(name = "hotel_name")
    private String hotelName; //酒店名字

    @Column(name = "hotel_msg")
    private String hotelMsg; //酒店信息

    @Column(name = "hotel_pic")
    private String hotelPic;   //酒店的图片

    @Column(name = "hotel_phone")
    private Integer hotelPhone; //酒店的电话

    @Column(name = "hotel_address")
    private String hotelAddress; //酒店的地址

    @Column(name = "hotelNormal_price")
    private String hotelNormalPrice; //酒店的正常价格

    @Column(name = "hotelFavorable_price")
    private String hotelFavorablePrice; //酒店的优惠价格

    @Column(name = "hotel_rank")
    private Integer hotelRank; //酒店的星级

    @Column(name = "hotel_score")
    private Double hotelScore;//酒店的评分


    @Column(name = "hotel_visits")
    private Long hotelVisits;//酒店的访问量

    //@JsonIgnoreProperties(value = {" comments"})
    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hotel")
    //@JsonBackReference //少的管理映射
    //@JoinColumn(name = "userId",referencedColumnName = "id")
    @OneToMany(mappedBy = "hotel_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<Comment>();

    @Column(name = "comment_count")
    private Long commentCount;//评论数量 不应该放到数据库里面

}