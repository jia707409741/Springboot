package com.leo.ssmproj.dao;


import com.leo.ssmproj.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao
{
    /**
     * 查询用户是否存在，若是存在则提示已存在
     * @param name
     * @return
     */
    @Select(value = "select u.name,u.pwd from t_user u where u.name=#{name}")
    User findUserNameByName(String name);

    /**
     * 新增用户
     *
     * 加入该注解可以保存对象后，查看对象插入id
     * @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
     * @param user
     */
    @Insert("insert into t_user (name,age,pwd) values(#{name},#{age},#{pwd})")
    void regist(User user);

    /**
     * 用户登录
     * @param user
     * @return
     */
    @Select("select u.id from t_user u where u.name = #{name} and u.pwd = #{pwd}")
    Long login(User user);
}
