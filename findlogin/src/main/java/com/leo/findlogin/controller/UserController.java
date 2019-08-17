package com.leo.findlogin.controller;

import com.leo.findlogin.bean.User;
import com.leo.findlogin.services.UserServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController
{
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserServices userServices;
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public boolean addUser(@RequestBody  User user){
        log.info("开始增加。。。");
        return userServices.addUser(user);
    }
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public boolean updateUser(@RequestBody User user){
        log.info("开始修改。。。");
        return userServices.updateUser(user);
    }
    @RequestMapping(value = "/find",method = RequestMethod.GET)
    public User findBody(@RequestParam(value = "name") String name){
        log.info("查询所有。。。");
        return userServices.findByUser(name);
    }
}
