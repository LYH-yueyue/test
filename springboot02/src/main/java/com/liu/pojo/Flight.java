package com.liu.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "lv_flight")
public class Flight {
    //航班号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //出发时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    //@Column(name="start_time")
    @Column(name = "start_time")
    private java.util.Date startTime;

    //达到时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "end_time")
    private java.util.Date endTime;

    //往返类型
    @Column(name = "range_type")
    private String rangeType;

    //始发城市
    @Column(name = "starting_city")
    private String startingCity;

    //目的城市
    @Column(name = "terminus_city")
    private String terminusCity;

    //单返票
    @Column(name = "oneway_price")
    private Integer onewayPrice;

    //往返票
    @Column(name = "goandback_price")
    private Integer goandbackPrice;

    //出发日期
    //@DateTimeFormat(pattern = "yyyy-MM-dd") //这个注解是把string 类型转化为date
    @Column(name = "start_date")
    private java.sql.Date startDate;

    //到达日期
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "arriving_date")
    private Date arrivingDate;

    //机票类型
    @Column(name = "pick_type")
    private String pickType;

    //机票数量
    @Column(name = "pick_count")
    private Integer pickCount;

}