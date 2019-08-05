package com.leo.login.service;

import com.leo.login.domain.Users;

import java.util.List;

public interface LoginService
{

    List<Users> findAll();

    Users findById(int id);

    int update(Users users);

    int delete(int id);

    int save(Users users);
}
