package com.ybx.web.controller;

import com.sun.xml.internal.xsom.impl.scd.Iterators;
import com.ybx.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController //声明Rest风格的控制器
//@EnableAutoConfiguration //自动配置，相当于写了spring的配置文件
@RequestMapping("user")
public class UserController {

    //http://127.0.0.1:8080/user/123(这个数字随便写)
    @RequestMapping("{id}")
    @ResponseBody //把return内容转成json
    public User userInfo(@PathVariable() Integer id){
        User user = new User("gyf", "123");
        user.setId(id);
        return user;
    }

    //http://127.0.0.1:8080/user/login?username=gyf&password=123
    @RequestMapping("/login")
    @ResponseBody //把return内容转成json
    public Map<String, Object> login(String username, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        if ("gyf".equals(username) && "123".equals(password)){
            map.put("success", 1);
            map.put("errMsg", "");
        }else {
            map.put("success", 0);
            map.put("errMsg", "name or password wrong!");
        }
        return map;
    }

    /*
    //临时的启动spring boot项目的方式,只启动一个控制器
    public static void main(String[] args) {
        SpringApplication.run(UserController.class, args);
    }
    */
}
