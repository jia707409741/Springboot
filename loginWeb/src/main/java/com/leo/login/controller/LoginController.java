package com.leo.login.controller;

import com.leo.login.domain.Users;
import com.leo.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController返回json数据格式
 * method = RequestMethod.GET   查
 * method = RequestMethod.POST  增
 * method = RequestMethod.PUT   改
 * method = RequestMethod.DELETE    删
 */
@RestController
@RequestMapping("/login")
public class LoginController
{
    @Autowired
   private LoginService loginService;
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public Object logintest(){
        return loginService.findAll();
    }

    @RequestMapping(value = "find",method = RequestMethod.GET)
    public Object findId(int pid){
        return loginService.findById(pid);
    }

    @RequestMapping(value = "update",method = RequestMethod.PUT)
    public Object update(int sid,String name){
        Users users=new Users();
        users.setId(sid);
        users.setSname(name);
        return loginService.update(users);
    }

    @DeleteMapping("delete")
    public Object delete(int id){
        return loginService.delete(id);
    }

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public int save(String sname,String spwd,String userdesc){
        Users users=new Users();
        users.setSname(sname);
        users.setSpwd(spwd);
        users.setUserdesc(userdesc);
        return loginService.save(users);
    }
}
