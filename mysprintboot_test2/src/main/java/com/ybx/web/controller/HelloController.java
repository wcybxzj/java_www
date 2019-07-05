package com.ybx.web.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //声明Rest风格的控制器
//@EnableAutoConfiguration //自动配置，相当于写了spring的配置文件
public class HelloController {

/*
    //http://127.0.0.1:8080/hello
    @RequestMapping("hello")
    @ResponseBody //把return内容转成json
    public String hello(){
        return "hello, Spring Boot";
    }
*/

    //http://127.0.0.1:8080/hello/ybx
    @RequestMapping("hello/{name}")
    @ResponseBody //把return内容转成json
    public String hello(@PathVariable("name") String name){
        return name + "hello, Spring Boot";
    }

    //测试全局exception捕获
    //http://127.0.0.1:8080/exception
    @RequestMapping("exception")
    @ResponseBody //把return内容转成json
    public String exception(){
        int i= 10/0;//引起运行时异常
        return "send exception, this line will not execute!";
    }

    /*
    //临时的启动spring boot项目的方式,只启动一个控制器
    public static void main(String[] args) {
        SpringApplication.run(HelloController.class, args);
    }
    */
}
