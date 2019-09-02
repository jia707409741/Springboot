package com.leo.ssmproj.services.impl;


import com.leo.ssmproj.bean.User;
import com.leo.ssmproj.dao.UserDao;
import com.leo.ssmproj.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpl implements UserServices
{
    @Autowired
    private UserDao userDao;

    /**
     * 注册
     * @param user
     * @return
     */
    @Override
    public User register(User user)
    {
        User result=new User();
        result.setSuccess(false);

        User existUser=userDao.findUserNameByName(result.getName());
        try
        {
            if (existUser !=null){
                result.setMsg("用户名已存在！");
            }
            else {
                userDao.regist(user);
                result.setMsg("注册成功");
                result.setSuccess(true);
            }
        } catch (Exception e){
            e.printStackTrace();
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @Override
    public User login(User user)
    {
        User result=new User();
        result.setSuccess(false);
        Long userId= userDao.login(user);
        try
        {
            if (userId == null){
                result.setMsg("用户名或密码不正确");
            }
            else {
                result.setMsg("登录成功！");
                result.setSuccess(true);
            }
        } catch (Exception e){
            e.getStackTrace();
            result.setMsg(e.getMessage());

        }

        return result;
    }
}
