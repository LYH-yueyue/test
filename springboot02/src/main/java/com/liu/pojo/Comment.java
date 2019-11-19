package com.liu.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //主键自增
    private Integer id;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "hotel_id")//要关联的列，在实体类中的名字和在表中的名字
    private Hotel hotel_id;//关联酒店的主键

    @Column(name = "comment_msg")
    private String comment_msg;//评论的内容

    @Column(name = "comment_date")
    private Date commentDate;//评论的时间

//    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
//    @JsonIgnore
//    @JoinColumn(name = "user_id")//要关联的列，在实体类中的名字和在表中的名字
//    private User user_id; //评论的人
//
//    public User getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(User user_id) {
//        this.user_id = user_id;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Hotel getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Hotel hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getComment_msg() {
        return comment_msg;
    }

    public void setComment_msg(String comment_msg) {
        this.comment_msg = comment_msg;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }
}
