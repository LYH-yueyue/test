package com.liu.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制页面跳转的控制器
 */
@Controller
@RequestMapping("html")
public class HtmlController {

    @RequestMapping("{html}")
    public String HtmlJump(@PathVariable("html") String name) {
        return name;
    }

}
