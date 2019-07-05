package com.ybx.web.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/*
 * 用于捕获全局异常
 */
@ControllerAdvice//切面
public class GlobalExceptionHandler {

    //处理异常的方法
    @ExceptionHandler(RuntimeException.class)//捕获运行时异常
    @ResponseBody
    public Map<String,Object> exceptionHander(){//处理异常方法
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("errorCode", "101");
        map.put("errorMsg", "系統错误!");
        return map;
    }
}

