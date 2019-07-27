package com.gyf.test2.mapper;

import com.gyf.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {

   @Insert("insert customer (name,tel) values (#{name},#{tel})")
    public int save(@Param("name") String name, @Param("tel") String tel);
}
