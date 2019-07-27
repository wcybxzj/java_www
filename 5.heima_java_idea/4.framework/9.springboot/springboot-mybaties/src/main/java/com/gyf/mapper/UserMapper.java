package com.gyf.mapper;

import com.gyf.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

   /* @Insert("insert t_user (username,password) values (#{username},#{password})")
    public int save(@Param("username") String username, @Param("password") String password);

    @Select("select * from t_user where username = #{username}")
    public User findByUsername(@Param("username") String username);*/

    public int save(String username,String password);

    public User findByUsername(String username);
}
