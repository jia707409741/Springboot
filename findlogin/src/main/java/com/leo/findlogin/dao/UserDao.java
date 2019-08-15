package com.leo.findlogin.dao;

import com.leo.findlogin.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao
{
    /**
     * 增加用户
     * @param user
     */
    @Insert("insert into t_user(id,name,age) values (#{id},#{name},#{age})")
    void addUser(User user);
}
