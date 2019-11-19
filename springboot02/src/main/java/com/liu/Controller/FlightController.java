package com.liu.Controller;

import com.liu.Repository.FlightRepository;
import com.liu.Service.FlightService;

import com.liu.pojo.Flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightService flightService;

    /**
     * 查询机票
     */
    @RequestMapping(value = "/find")

    public String findPick(Flight flight, HttpSession session) {

        List<Flight> flights = flightService.findByCondition(flight);
        System.out.println(flights);
        session.setAttribute("flights", flights);
        return "flight_table";
    }

    /**
     * 预订机票
     */
    @GetMapping("/{id}")
    public String BuyFlight(@PathVariable("id") Integer id, HttpSession session) {
        //跳转到购买机票的页面(未实现的功能)
        //根据id来看改机票是否还有余票(这里先不考虑线程并发的问题)
        Flight flight = flightRepository.getOne(id);
        if (flight.getPickCount() > 0) {
            flight.setPickCount(flight.getPickCount() - 1);

            flightRepository.save(flight);//这里返回一个flight对象

            return "/common/success";
        } else {
            session.setAttribute("msg", "真遗憾,票已经售卖完了！");
            return "flight_table";
        }

    }

//
}
