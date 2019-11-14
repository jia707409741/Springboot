package com.leo.wxcx.dao;

import com.github.pagehelper.Page;
import com.leo.wxcx.bean.TMusic;
import com.leo.wxcx.bean.TUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TUserDao
{
    @Select("select count(1) from t_user where name=#{name} and pwd=#{pwd}")
    int login(TUser tUser);

    @Select("select * from t_user")
    List<TUser> SelectAll();

    @Update("UPDATE t_user SET NAME=#{name},pwd=#{pwd} WHERE id=#{id}")
    void updateUser(TUser tUser);

    @Insert("INSERT INTO t_user(NAME,age,pwd,sex,imageurl) VALUES(#{name},#{age},#{pwd},#{sex},#{imageurl})")
    void insertUser(TUser tUser);

    @Delete("DELETE FROM t_user WHERE id=#{id}")
    void deleteUser(TUser tUser);

    @Select("SELECT COUNT(1) FROM t_user WHERE name=#{name}")
    int queryOneName(String name);

    @Select("select * from t_user where id=#{id}")
    List<TUser> findOneUser(int id);

    /**
     * 这里没有必要传参，直接在sql语句里写死category就行
     * @param category
     * @return
     */
    @Select("select url from t_images where category=#{category}")
    List<String> findAllImage(int category);

    /**
     * 音乐查询
     * @return
     */
    @Select("SELECT mid,mname,murl,mauthor FROM t_music")
    List<TMusic> findMusicList();
    /**
     * 分页的方法，暂时不需要
     * @return
     */
    @Select("select * from t_user")
    Page<TUser> findByPage();

    @Select("SELECT url FROM t_images i WHERE i.`category`=2 AND i.name=#{name}")
    List<String> findAllXingzuo(String name);
}
