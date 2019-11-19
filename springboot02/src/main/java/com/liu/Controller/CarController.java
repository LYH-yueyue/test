package com.liu.Controller;

import com.liu.Service.CarService;
import com.liu.pojo.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("car")
public class CarController {
    @Autowired
    private CarService carService;

    private Integer page_index = 0;//初始的页号

    private Integer page_size = 5;//页面的大小

    @RequestMapping("list")
    public String carList() {
        return "Car_table";
    }

    @RequestMapping("test")
    public String test(Car car, HttpSession session) {
        Page<Car> cars = carService.findAll(car, new PageRequest(page_index, page_size));
        session.setAttribute("cars", cars);
        session.setAttribute("car", car);//把查询的条件存入到session中，等跳天数的时候，传数据
        return "redirect:/car/list";
    }

    /**
     * 改变时间的汽车查询
     */
    @GetMapping("changedate")
    public String Change(@RequestParam("date") String str, HttpSession session) throws Exception {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
        Car car = (Car) session.getAttribute("car");
        car.setStartDate(date);
        System.out.println(str);

        session.setAttribute("car", car);
        Page<Car> cars = carService.findAll(car, new PageRequest(page_index, page_size));

        for (Car car1 : cars) {
            System.out.println(car1);
        }
        session.setAttribute("cars", cars);
        return "redirect:/car/list";
    }

    /**
     * 分页
     *
     * @return
     */
    @GetMapping("page")
    public String changepage(@RequestParam("flag") String flag, HttpSession session) {
        if (Integer.parseInt(flag) == 1) {
            System.out.println(111111111);
            page_index--;
        } else if (Integer.parseInt(flag) == 2) {
            page_index++;
        }
        Car car = (Car) session.getAttribute("car");
        Page<Car> cars = carService.findAll(car, new PageRequest(page_index, page_size));
        session.setAttribute("cars", cars);
        //test((Car)session.getAttribute("car"),session);//不接受传回来的字符串
        return "redirect:/car/list";
    }


    /**
     * 根据前端传过来的id买汽车票
     *
     * @param id
     */
    @RequestMapping("pick/{id}")
    public void pickID(@PathVariable("id") Integer id) {
        System.out.println(id);
    }

}

