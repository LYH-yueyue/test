package com.liu.Controller;

import com.liu.Repository.ScenicRepository;
import com.liu.Repository.UserRepository;


import com.liu.pojo.Scenic;
import com.liu.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping(value = "/user", produces = {"application/json;charset=UTF-8"})
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScenicRepository scenicRepository;

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */

    @RequestMapping("login")
    public String login(@RequestParam(value = "username", required = false) String username,
                        @RequestParam(value = "password", required = false) String password) {

        User user = userRepository.findUserByUsernameAndPassword(username, password);//获取登录的用户

        if (user != null) {
            return "index2";
        }
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        Subject subject = SecurityUtils.getSubject();
//        subject.login(token);
        return "index";
    }

    @RequestMapping("like")
    @ResponseBody
    public Map<String, String> like(@RequestParam("type") String type,
                                    @RequestParam("id") Integer id,
                                    HttpSession session) {
        Map<String, String> map = new HashMap<>();
        User user = (User) session.getAttribute("user");
        if (type.equals("scenic")) {
            Set<Scenic> scenics = user.getCollection().getScenics();
            Scenic scenic = scenicRepository.findScenicById(id);
        }
        return map;
    }

}
