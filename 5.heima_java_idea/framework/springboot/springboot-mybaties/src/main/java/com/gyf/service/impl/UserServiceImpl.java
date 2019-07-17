package com.gyf.service.impl;

import com.gyf.mapper.UserMapper;
import com.gyf.model.User;
import com.gyf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(String username, String password) {
        userMapper.save(username,password);
        //int i = 10/0;
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
