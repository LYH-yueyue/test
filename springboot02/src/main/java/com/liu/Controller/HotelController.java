package com.liu.Controller;

import com.liu.Repository.CommentRepository;
import com.liu.Repository.HotelRepository;
import com.liu.Repository.RoomRepository;
import com.liu.Service.HotelService;
import com.liu.Service.RoomService;
import com.liu.pojo.Comment;
import com.liu.pojo.Hotel;
import com.liu.pojo.Room;
import com.liu.pojo.Roomtype;
import com.liu.util.Lv_util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.PageRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.liu.util.Lv_util;

@Controller
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelRepository hotelRepository;

    //@Autowired
//    private CommentRepository commentRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HotelService hotelService;

    /**
     * 根据名字查询酒店
     *
     * @param name
     * @param session
     * @return
     */
    @RequestMapping("{hotel_name}")
    public String findHotelByName(@PathVariable("hotel_name") String name, HttpSession session) {
        Hotel byHotelName = hotelRepository.findByHotelName(name);
        session.setAttribute("hotel", byHotelName);
        return "";
    }

    /**
     * 动态查询
     *
     * @return
     */
    private int page_index = 0;//分页的默认显示页

    private int pageSize = 2;//分页的每页大小;

    private int pageTotal = 0;//总的页数

    @RequestMapping("/find")
    public String findHotel(Hotel hotel, HttpSession session) {
        Page<Hotel> hotels = hotelService.findByCondition(hotel, new PageRequest(page_index, pageSize));
        pageTotal = hotels.getTotalPages();//总共多少页
        session.setAttribute("page_index", page_index);//当前的页
        session.setAttribute("totalPage", pageTotal);//放到request中
        for (Hotel hotell : hotels) {
            String msg = Lv_util.readFileContent(Hotel_Summary_filePath + hotell.getHotelMsg());
            hotell.setHotelMsg(msg);
        }
        session.setAttribute("hotels", hotels);
        return "travel_list";
        //return "travel_list :: hotels";
    }

    /**
     * 根据传过来的条件，给酒店排序
     * (还未实现局部刷新)1.iframe框架实现
     * 2.ajax
     */


    @RequestMapping("/find/{fliter}")
    public String findSortHotel(@PathVariable(name = "fliter") String fliter, HttpSession session) {
        //根据fliter排序
        PageRequest page = new PageRequest(page_index, pageSize, Sort.by(Sort.Direction.DESC, fliter));
        Page<Hotel> hotels = hotelRepository.findAll(page);

        session.setAttribute("hotels", hotels);
        return "travel_list";

    }

    /**
     * 根据传过来的酒店id,来获取酒店的信息
     */
    private final static String Hotel_Summary_filePath = Lv_util.pathName + "static/msg/";

    @RequestMapping("/{hotelName}/{id}")
    public String hotelNameAndId(@PathVariable("id") Integer id, HttpSession session) {
        Hotel hotel = hotelRepository.findHotelById(id);
        String msg = Lv_util.readFileContent(Hotel_Summary_filePath + hotel.getHotelMsg());
        hotel.setHotelMsg(msg);
        //System.out.println(hotel.getComments());

        session.setAttribute("hotel", hotel);
        Room roomset = roomRepository.findRoomById(hotel.getId());
        //把set集合转化为list
        List<Roomtype> roomtypes = new ArrayList<>();
        Iterator<Roomtype> iterator = roomset.getRoomtypeSet().iterator();
        while (iterator.hasNext()) {
            roomtypes.add(iterator.next());
        }
        session.setAttribute("roomtypes", roomtypes);
        return "travel_detail";
    }

    @GetMapping("/page")
    public String hotelPage(@RequestParam(value = "flag", required = true) String flag) {
        System.out.println(flag == "1");
        if (flag.equals("1")) {
            if (page_index != 0) page_index--;
        } else {
            page_index++;
        }
        return "redirect:/hotel/find";
    }

}
