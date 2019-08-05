package com.leo.login.mapper;

import com.leo.login.domain.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface LoginMapper
{
    @Select("select * from t_users")
    List<Users> findAll();

    @Select("select * from t_users where id=#{id}")
    Users findById(int id);

    @Update("update t_users set sname=#{sname} where id=#{id}")
    int update(Users users);

    @Delete("delete from t_users where id=#{id}")
    int delete(int id);

    @Insert("insert into t_users (sname,spwd,userdesc) values (#{sname},#{spwd},#{userdesc})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int save(Users users);
}
