package com.liu.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * 酒店的房间
 */
@Data
@Entity
@Table(name = "lv_room")

public class Room implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "hotel_id")
    Integer hotel_id;//对应的酒店的id

    //    @Column(name = "room_count")
//    private Integer roomCount;//房间在没有售卖的时候的总的房间数量
//
//    @Column(name = "room_residue")
//    private Integer roomResidue;//房间剩余数量
    @Column(name = "roomtype_id")
    private Integer roomtypeId;//酒店房间类型的id

    //all代表所有情况下都关联操作， lazy表示懒加载，该属性不会马上从数据库加载
//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    @JoinColumn(name = "room_id",referencedColumnName = "id")
    @OneToMany(mappedBy = "roomId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Roomtype> roomtypeSet = new HashSet<Roomtype>();
}
