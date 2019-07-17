package com.gyf.web.controller;

import com.gyf.test1.service.UserServiceImpl;
import com.gyf.test2.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//展示1个Service使用2个数据源时候的问题
@RestController
@RequestMapping("user2")
public class UserController2 {
    @Autowired
    private UserServiceImpl userService;

    //http://127.0.0.1:8080/user2/register2?username=ybx002&password=456
    @RequestMapping("register2")
    @ResponseBody
    public String register2(String username,String password){
        //把数据保存到test1数据库
        userService.register2(username,password);
        return "success";
    }
}
