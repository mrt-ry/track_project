package com.example.demo.domain.User;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserRepository {

    @Select("select * from users where userName = #{name}")
    Userdata findByUserName(String name);

    @Insert("insert into users (userName,password) values (#{name}, #{password})")
    int createUser(String name, String password);

    @Update("update users set image = #{filePath} where userName = #{name}")
    int changeIcon(String name, String filePath);

}