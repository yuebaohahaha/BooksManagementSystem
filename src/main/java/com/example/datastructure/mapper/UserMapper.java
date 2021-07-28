package com.example.datastructure.mapper;

import com.example.datastructure.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Insert("insert into user (username,password) values (#{username},#{password})")
    void adduser(User user);

    @Select("select * from user where username=#{username}")
    User getuser(String username);

    @Select("Select * from user where username=#{username} and password=#{password}")
    User login(String username,String password);

    @Update("update user set password=#{password} where username=#{username}")
    void updateuser(String username,String password);
}
