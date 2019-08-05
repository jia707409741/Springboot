package com.leo.login.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OtherController
{
    private Map<String,Object> map=new HashMap<>();

    @PostMapping("/v2/login")
    public Object login(String sname,String spwd){
        map.clear();
        map.put("sname",sname);
        map.put("spwd",spwd);
        return map;
    }

    @PutMapping("/v2/put")
    public Object put(String id){
        map.clear();
        map.put("id",id);
        return map;
    }
}
