package com.leo.findlogin.dao;

import com.leo.findlogin.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface UserDao
{
    /**
     * 增加用户
     * @param user
     */
    @Insert("insert into t_user(id,name,age) values (#{id},#{name},#{age})")
    void addUser(User user);

    /**
     * 修改用户
     * @param user
     */
    @Update("update t_user set name=#{name},age=#{age} where id=#{id}")
    void updateUser(User user);

    /**
     * 查询用户
     * @param name
     * @return
     */
    @Select("select * from t_user")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "age",column = "age")
    })
    User findByUser(@Param("name") String name);
}
