package com.gyf.test1.service;

import com.gyf.model.User;
import com.gyf.test1.mapper.UserMapper;
import com.gyf.test2.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl{
    @Autowired
    private UserMapper userMapper;


    @Autowired
    private CustomerMapper customerMapper;
    public void register(String username, String password) {
        //解决springboot-multi/src/main/java/com.gyf/test1/service/UserServiceImpl中情况2的问题
        //因为使用了jta做的多数据源事务管理,而不是在datasource做的事务管理,所以两个保存都没有提交
        customerMapper.save(username,"110");
        int i = 10 / 0;
        userMapper.save(username,password);
    }
}
