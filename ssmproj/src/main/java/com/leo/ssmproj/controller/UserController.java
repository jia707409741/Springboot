package com.leo.ssmproj.controller;

import com.leo.ssmproj.bean.User;
import com.leo.ssmproj.services.UserServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController //=@Controller + @ResponseBody
@RequestMapping(value = "/api/user")
public class UserController
{
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserServices userServices;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public User register(User user){
        log.info(user.getName()+","+user.getAge()+","+user.getPwd());
        return userServices.register(user);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public User login(User user){
        log.info("视图跳转。。。。");
        System.out.println(user.getName()+","+user.getPwd());
        return userServices.login(user);
    }
}
