package com.ybx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */


//测试1:
//http://127.0.0.1:8080/hello/ybx

//测试2:
//http://127.0.0.1:8080/user/123

//测试3:静态资源
//http://127.0.0.1:8080/imgs/1.jpeg

//springboot自动配置
@EnableAutoConfiguration
//扫描包中的所有控制器
//@ComponentScan(basePackages ={"包1"，"包2"} )
@ComponentScan(basePackages = "com.ybx.web")
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
