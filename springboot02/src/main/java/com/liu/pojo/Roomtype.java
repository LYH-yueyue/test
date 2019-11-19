package com.liu.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;


@Entity

@Table(name = "lv_roomtype")
public class Roomtype implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //    @JsonIgnoreProperties(value = { "room" })//注解排除了Roomtype中的room字段，从而避免了死循环问题。
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "room_id")//要关联的列，在实体类中的名字和在表中的名字
    private Room roomId = new Room();//要关联的是哪一个表

    @Column(name = "roomtype_type")
    private String roomType; //房间的类型

    @Column(name = "roomtype_price")
    private Integer roomtypePrice; //房间的价格

    @Column(name = "roomtype_count")
    private Integer roomtypeCount;//该类房间总的房间数量

    @Column(name = "roomtype_pic")
    private String roomtypePic;//房间类型的照片

    @Column(name = "roomtype_residue")
    private Integer roomtypeResidue;//该房间剩余数量

    @Column(name = "roomtype_rank")
    private Integer roomtypeRank; //房间的评分

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Integer getRoomtypePrice() {
        return roomtypePrice;
    }

    public void setRoomtypePrice(Integer roomtypePrice) {
        this.roomtypePrice = roomtypePrice;
    }

    public Integer getRoomtypeCount() {
        return roomtypeCount;
    }

    public void setRoomtypeCount(Integer roomtypeCount) {
        this.roomtypeCount = roomtypeCount;
    }

    public Integer getRoomtypeResidue() {
        return roomtypeResidue;
    }

    public void setRoomtypeResidue(Integer roomtypeResidue) {
        this.roomtypeResidue = roomtypeResidue;
    }

    public String getRoomtypePic() {
        return roomtypePic;
    }

    public void setRoomtypePic(String roomtypePic) {
        this.roomtypePic = roomtypePic;
    }

    public Integer getRoomtypeRank() {
        return roomtypeRank;
    }

    public void setRoomtypeRank(Integer roomtypeRank) {
        this.roomtypeRank = roomtypeRank;
    }
}
