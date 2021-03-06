package com.gyf.web.controller;

import com.gyf.model.User;
import com.gyf.service.IUserService;
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

    @RequestMapping("{id}")
    @ResponseBody
    /**
     * 通过id查询用户的信息
     */
    public User userInfo(@PathVariable() Integer id){
        User user = new User("gyf","123");
        user.setId(id);
        //int i = 10/0;
        return user;
    }

    /*public static void main(String[] args) {
        //启动springboot项目
        SpringApplication.run(UserController.class,args);
    }*/

    //http://127.0.0.1:8080/user/register?username=ybx&password=123
    @Autowired
    private IUserService userService;
    @RequestMapping("register")
    @ResponseBody
    public String register(String username,String password){
        userService.register(username,password);
        return "success";
    }

    @RequestMapping("find")
    @ResponseBody
    public User find(String username){
        return userService.findByUsername(username);
    }
}
