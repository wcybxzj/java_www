package com.ybx.web.controller;

import com.alipay.api.DefaultAlipayClient;
import com.ybx.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @RestController 用于写API,给移动客户端提供数据,一般是返回json数据
 * @Controller 一般用于写后(有页面)
 */
@RestController
@RequestMapping("alipay")
public class AliPayController {

    @RequestMapping("test")
    public String test(){
        //new DefaultAlipayClient();
        return "ok";
    }

}
