package com.liu.Repository;

import com.liu.pojo.Comment;

import com.liu.pojo.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer>, JpaSpecificationExecutor<Integer> {

//    @Query("select count(c) from Comment c where c.hotel = :id ")
//    Long findHotelCommentCount(@Param("id") Hotel hotel);
//      List<Comment> findAllByHotel(Integer id);
}
