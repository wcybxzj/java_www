package com.gyf.service;

import com.gyf.model.User;

public interface IUserService {
    public void register(String username,String password);
    public User findByUsername(String username);
}
