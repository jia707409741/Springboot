package com.leo.findlogin.controller;

import com.leo.findlogin.bean.User;
import com.leo.findlogin.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController
{
    @Autowired
    private UserServices userServices;
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public boolean addUser(@RequestBody  User user){
        System.out.println("开始增加。。。");
        return userServices.addUser(user);
    }
}
