package com.liu.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Column;

@RequestMapping("hello")
@Controller
public class HelloController {

    @RequestMapping("/{name}")
    public String Hello(@PathVariable("name") String name) {

        return "" + name;
    }

}
