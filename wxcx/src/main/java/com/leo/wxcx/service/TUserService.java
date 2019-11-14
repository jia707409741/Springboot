package com.leo.wxcx.service;

import com.github.pagehelper.PageInfo;
import com.leo.wxcx.bean.TUser;

import java.util.List;

public interface TUserService
{
    int login(TUser tUser);

    List<TUser> SelectAll();

    boolean updateUser(TUser tUser);

    boolean insertUser(TUser tUser);

    boolean deleteUser(TUser tUser);

    int queryOneName(String name);

    List<TUser> findOneUser(int id);

    List<String> findAllImage(int category);

    //PageInfo<TUser> findByPage(int pageNo, int pageSize);

    List<String> findAllXingzuo(String name);

    List findMusicList();
}
