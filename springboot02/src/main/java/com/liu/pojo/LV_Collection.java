package com.liu.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/***
 * 收藏类
 * 和用户类是一对一的关系
 */
@Entity
@Table(name = "lv_collection")
@Data
public class LV_Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //主键自增
    private Integer id;

    @OneToMany(targetEntity = Scenic.class, cascade = {CascadeType.PERSIST})//CascadeType.PERSIST级联新增
    @JoinColumn(name = "col_scenic_id", referencedColumnName = "id")
    // @OneToMany(mappedBy = "scenic_id",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Scenic> scenics;//收藏的景点，一对多的单向关联

    //@OneToMany(mappedBy = "hotel_id",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @OneToMany(targetEntity = Hotel.class, cascade = {CascadeType.PERSIST})//CascadeType.PERSIST级联新增
    @JoinColumn(name = "col_hotel_id", referencedColumnName = "id")
    private Set<Hotel> hotels; //收藏的酒店

}
