package com.liu.pojo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "lv_scenic")
public class Scenic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "place")
    private String place;//景点名
    @Column(name = "place_msg")
    private String placeMsg;//景点信息
    @Column(name = "place_pic")
    private String placePic;//景点照片
    @Column(name = "price")
    private String price;//景点的价格

}