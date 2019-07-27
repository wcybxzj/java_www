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
        userMapper.save(username,password);
    }

    //1个service中使用2个数据源中出的问题,
    public void register2(String username, String password) {
        /*
        //情况1:都没插入数据
        userMapper.save(username,password);
        int i =10/0;//异常
        customerMapper.save(username, "110");
        */

        //情况2:第一个插入了，第二个没插入
        //这里第一个插入的原因是:
        //因为当前service用的是和datasource/DataSource01绑定的
        //而他的事务是针对userMapper的而不是customerMapper
        customerMapper.save(username, "110");
        int i =10/0;//异常
        userMapper.save(username,password);

        //情况3:解决情况2中的问题
        //springboot中的多事务管理
        //使用springboot+jta+atomikos 分布式事务管理解决方案
        //代码需要去看springboot-j                                                                              ta-log4j项目
    }

}
