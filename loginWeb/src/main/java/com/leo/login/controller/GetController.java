package com.leo.login.controller;

import com.leo.login.domain.Users;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Data:2019/07/21
 * User:Leo
 */
@RestController
public class GetController
{
    private Map<String,Object> map=new HashMap<>();

    /**
     * @PathVariable是用来获得请求url中的动态参数的,所以当url参数为动态的话，这个注解则有必要使用
     * 如果路径的参数和传入的参数保持一致的话，那么则不需要进行中间转义；
     */
    @RequestMapping(path = "/{sname}/{spwd}",method = RequestMethod.GET)
    public Object find(@PathVariable String sname,@PathVariable("spwd") String pwd){
        map.put("loginname",sname);
        map.put("password",pwd);
        return map;
    }

    /**
     @RequestParam定义参数的注解
     */
    @GetMapping("/get/form")
    public Object find1( @RequestParam(defaultValue = "0") String sname,String pwd){
        map.put("loginname",sname);
        map.put("password",pwd);
        return map;
    }

    /**
     * Bean对象传参（重点）
     * @RequestBody使用body传输数据
     * 使用postman测试真的好麻烦，要把json的格式改成application/json，然后选择Body->raw,输入测试数据，并且必须要用
     * json格式进行输入
     * {
     * 	"sname":"333",
     * 	"spwd":"333rr"
     * }
     */
    @RequestMapping("param/v1")
    public Object find2(@RequestBody Users user)
    {
        map.clear();
        map.put("User",user);
        return map;
    }

    /**
     *使用postman工具进行测试的时候，选中Header，将key换成@RequestHeader注解定义的key
     */
    @RequestMapping(value = "/v1/author",method = RequestMethod.GET)
    public Object getHeader(@RequestHeader("access_token") String accesToken,String id){
        map.clear();
        map.put("token",accesToken);
        map.put("id",id);
        return map;
    }

    /**
     * HttpServletRequest request 自动注入参数
     */
    @GetMapping("v1/serv")
    public Object request(HttpServletRequest request)
    {
        map.clear();
        String id=request.getParameter("id");
        map.put("id",id);
        return map;
    }
}
