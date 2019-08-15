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
}
