package com.leo.login.service.impl;

import com.leo.login.domain.Users;
import com.leo.login.mapper.LoginMapper;
import com.leo.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoginServiceImpl implements LoginService
{
    @Autowired
    private LoginMapper loginMapper;
    @Override
    public List<Users> findAll()
    {
        return loginMapper.findAll();
    }

    @Override
    public Users findById(int id)
    {
        return loginMapper.findById(id);
    }

    @Override
    public int update(Users users)
    {
       return loginMapper.update(users);
    }

    @Override
    public int delete(int id)
    {
       return loginMapper.delete(id);
    }

    @Override
    public int save(Users users)
    {
        return loginMapper.save(users);
    }
}
