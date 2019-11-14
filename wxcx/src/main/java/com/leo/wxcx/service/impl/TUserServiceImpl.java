package com.leo.wxcx.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leo.wxcx.bean.TImage;
import com.leo.wxcx.bean.TUser;
import com.leo.wxcx.dao.TUserDao;
import com.leo.wxcx.service.TUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TUserServiceImpl
 * @Description: TODO
 * @Author lenovo
 * @Date 2019/10/24
 * @Version V1.0
 */
@Service
@Slf4j
public class TUserServiceImpl implements TUserService
{
    private static final org.slf4j.Logger log=org.slf4j.LoggerFactory.getLogger(TUserServiceImpl.class);
    @Autowired
    private TUserDao tUserDao;
    @Override
    public int login(TUser tUser)
    {
       int a=tUserDao.login(tUser);
       if (a==1)
       {
           log.info("登录成功！");
           return 1;
       }

       log.info("错误！！");
        return 0;
    }

    //public String

    @Override
    public List<TUser> SelectAll()
    {
        return tUserDao.SelectAll();
    }

    @Override
    public boolean updateUser(TUser tUser)
    {
        boolean flag=false;
        try
        {
            tUserDao.updateUser(tUser);
            flag=true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean insertUser(TUser tUser)
    {
        boolean flag=false;
        try
        {
            tUserDao.insertUser(tUser);
            flag=true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteUser(TUser tUser)
    {
        boolean flag= false;
        try{
            tUserDao.deleteUser(tUser);
            flag=true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int queryOneName(String name)
    {
        int a=tUserDao.queryOneName(name);
        if (a==1)
        {
            log.info("对不起，请换个名称！");
            return 1;
        }

        log.info("确认唯一！");
        return 0;
    }

    @Override
    public List<TUser> findOneUser(int id)
    {
        return tUserDao.findOneUser(id);
    }

    @Override
    public List<String> findAllImage( int category)
    {
        return tUserDao.findAllImage(category);
    }

    /**
     * 使用pagehelper分页
     * @param pageNo
     * @param pageSize
     * @return

    @Override
    public PageInfo<TUser> findByPage(int pageNo, int pageSize)
    {
        PageHelper.startPage(pageNo,pageSize);
        List<TUser> listUser = tUserDao.findByPage();
        PageInfo<TUser> pageInfo=new PageInfo<>(listUser);
        return pageInfo;
    }*/

    @Override
    public List<String> findAllXingzuo(String name)
    {
        return tUserDao.findAllXingzuo(name);
    }

    @Override
    public List findMusicList()
    {
        return tUserDao.findMusicList();
    }
}
