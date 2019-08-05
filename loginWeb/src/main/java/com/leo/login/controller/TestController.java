package com.leo.login.controller;

//import com.leo.login.config.LoginConfig;
import com.leo.login.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController
{
    @RequestMapping("/testconfig")
    public Map<String,String> test()
    {
        Map<String,String> map=new HashMap<>();
        map.put("id","1");
        map.put("name","jcl");
        return map;
    }

    @Autowired
    private LoginMapper loginMapper;//可以忽略，这不算报错
    @RequestMapping("/testdb")
    public Object testdb(){
        return loginMapper.findAll();
    }
}
