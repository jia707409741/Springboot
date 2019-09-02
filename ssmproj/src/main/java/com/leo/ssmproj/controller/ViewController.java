package com.leo.ssmproj.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/api/view")
public class ViewController
{
    private static final org.slf4j.Logger log=org.slf4j.LoggerFactory.getLogger(ViewController.class);
    @ResponseBody
    @RequestMapping("/login")
    public ModelAndView login()
    {
        log.info("视图跳转。。。");
        return new ModelAndView("login");
    }

    @ResponseBody
    @RequestMapping("/success")
    public ModelAndView success()
    {
        log.info("视图跳转。。。");
        return new ModelAndView("success");
    }

    @ResponseBody
    @RequestMapping("/register")
    public ModelAndView register()
    {
        log.info("视图跳转。。。");
        return new ModelAndView("register");
    }
    /**
     * 上传文件页面视图跳转控制器
     * @return
     */
    @ResponseBody
    @RequestMapping("/upload")
    public ModelAndView UpLoad(){
        log.info("上传页面跳转。。。");
        return new ModelAndView("upload");
    }
}
