package com.example.demo.domain.User;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserRepository{

    @Select("select * from users where userName = #{name}")
    Userdata findByUserName(String name);

    @Insert("insert into users (userName,password) values (#{name}, #{password})")
    int createUser(String name, String password);
}