package com.gyf.web.controller;

import com.gyf.model.User;
import com.gyf.test1.service.UserServiceImpl;
import com.gyf.test2.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //声明Rest风格的控制器
//@EnableAutoConfiguration //自动配置，相当于写了spring的配置文件
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private CustomerServiceImpl customerService;

    //http://127.0.0.1:8080/user/register?username=ybx001&password=123
    @RequestMapping("register")
    @ResponseBody
    public String register(String username,String password){
        //把数据保存到test1数据库
        userService.register(username,password);

        //int i=10/0;

        //把数据保存到test2数据库
        customerService.save(username,"120");
        return "success";
    }
}
