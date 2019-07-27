package com.gyf.test1.mapper;

import com.gyf.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    @Insert("insert user (username,password) values (#{username},#{password})")
    public int save(@Param("username") String username, @Param("password") String password);


}
