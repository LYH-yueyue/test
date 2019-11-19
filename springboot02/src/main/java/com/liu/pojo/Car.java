package com.liu.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

@Data
@Entity
@Table(name = "lv_car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "start_local")
    private String startLocal;//发车的地方

    @Column(name = "end_local")
    private String endLocal; //到达的地方

    @Column(name = "car_price")
    private Integer carPrice;//车票的价格

    @Column(name = "car_pickcount")
    private Integer carPickCount;//车票的数量

    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "start_time")
    private Date startTime;//开始的时间

    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "end_time")
    private Date endTime; //到达的时间

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "start_date")
    private Date startDate;//出发的日期

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "end_date")
    private Date endDate; //到达的日期

}
