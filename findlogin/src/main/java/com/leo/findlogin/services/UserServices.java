package com.leo.findlogin.services;

import com.leo.findlogin.bean.User;

public interface UserServices
{
    /**
     * 增加用户
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    boolean updateUser(User user);

    /**
     * 查询用户
     * @param name
     * @return
     */
    User findByUser(String name);
}
