package com.leo.findlogin.services.impl;

import com.leo.findlogin.bean.User;
import com.leo.findlogin.dao.UserDao;
import com.leo.findlogin.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServicesImpl implements UserServices
{
    @Autowired
    private UserDao userDao;

    /**
     * @Transactional详解：https://zhuanlan.zhihu.com/p/60406545
     * 虽然 @Transactional 注解可以作用于接口、接口方法、类以及类方法上，
     * 但是 Spring 建议不要在接口或者接口方法上使用该注解，因为这只有在使用基于接口的代理时它才会生效
     * @param user
     * @return
     */
    @Transactional
    @Override
    public boolean addUser(User user)
    {
        boolean flag=false;
        try
        {
            userDao.addUser(user);
            flag=true;
        }
        catch (Exception e)
        {
            e.getStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateUser(User user)
    {
        boolean flag=false;
        try
        {
            userDao.addUser(user);
            flag=true;
        }
        catch (Exception e)
        {
            e.getStackTrace();
        }
        return flag;
    }

    @Override
    public List<User> findByUser(String name)
    {
        return userDao.findByUser(name);
    }
}
