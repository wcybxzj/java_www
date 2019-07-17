package com.gyf.web.controller;

import com.gyf.model.User;
import com.gyf.test1.service.UserServiceImpl;
import com.gyf.test2.service.CustomerServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //声明Rest风格的控制器
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    Logger logger = Logger.getLogger(UserController.class);

    //http://127.0.0.1:8080/user/register?username=ybx007&password=456
    @RequestMapping("register")
    @ResponseBody
    public String register(String username,String password){

        logger.info("====="+"username:"+username+"pasword:"+password);

        //把数据保存到test1数据库
        userService.register(username,password);
        return "success";
    }

    @RequestMapping("login")
    @ResponseBody
    public String login(String username,String password){
        return "success";
    }


}
