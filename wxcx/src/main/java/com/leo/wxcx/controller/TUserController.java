package com.leo.wxcx.controller;

import com.github.pagehelper.PageInfo;
import com.leo.wxcx.bean.TMusic;
import com.leo.wxcx.bean.TUser;
import com.leo.wxcx.service.TUserService;
import com.leo.wxcx.utils.LocalNetUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.core.ApplicationPart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.sql.Timestamp;
import java.util.*;

/**
 * @ClassName TUserController
 * @Description: TODO
 * @Author lenovo
 * @Date 2019/10/24
 * @Version V1.0
 **/
@Slf4j
@Controller //=@Controller + @ResponseBody
@RequestMapping(value = "/api/user")
public class TUserController
{
    //    private static String imgUrl= LocalNetUtils.natApp;
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TUserController.class);
    @Autowired
    private TUserService tUserService;

    @RequestMapping(value = "/login")
    public String login()
    {
        //log.info("视图跳转。。。。");
        //log.info("用户名："+name+"\t"+"密码:"+pwd);
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "/loginMethod", method = RequestMethod.POST)
    public Map<String, Object> loginMeth(@RequestBody TUser tUser)
    {
        //log.info("用户名："+name+"\t"+"密码:"+pwd);
        Map<String, Object> map = new HashMap();
        map.put("result", tUserService.login(tUser));
        //log.info(String.valueOf(map));
        return map;
    }

    /**
     * 返回结果是list
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/selectall", method = RequestMethod.GET)
    public String selectAll(Model model)
    {
        List<TUser> list = tUserService.SelectAll();
        model.addAttribute("emps", list);
        log.info(String.valueOf(list));
        return "firstPage";
    }

    @ResponseBody
    @RequestMapping(value = "/selectAllMap", method = RequestMethod.GET)
    public Map<String, Object> selectAllMap(Model model)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("map1", tUserService.SelectAll());
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public Map<String, Object> updateUser(@RequestBody TUser tUser)
    {//@RequestBody的作用其实是将json格式的数据转为java对象。
        log.info("开始更新。。。" + tUser);
        Map<String, Object> map = new HashMap<>();
        map.put("success", tUserService.updateUser(tUser));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    public Map<String, Object> insertUser(@RequestBody TUser tUser)
    {
        log.info("开始添加。。。");
        Map<String, Object> map = new HashMap<>();
        map.put("success", tUserService.insertUser(tUser));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
    public Map<String, Object> deleteUser(@RequestBody TUser tUser)
    {
        log.info("开始删除。。。" + tUser);
        Map<String, Object> map = new HashMap<>();
        map.put("success", tUserService.deleteUser(tUser));
        return map;
    }

    /**
     * 根据用户名来校验唯一性
     *
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryOneName", method = RequestMethod.POST)
    public Map<String, Object> queryOneName(@RequestParam String name)
    {
        Map<String, Object> map = new HashMap();
        log.info(name);
        map.put("result", tUserService.queryOneName(name));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/findUserOne", method = RequestMethod.GET)
    public Map<String, Object> findUserOne(@RequestParam int id)
    {
        log.info("开始查询单个用户。。。");
        Map<String, Object> map = new HashMap<>();
        map.put("oneUserInfo", tUserService.findOneUser(id));
        return map;
    }

    /**
     * 传输注册页的轮播图图片
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findAllImage", method = RequestMethod.GET)
    public List findAllImage(int category)
    {
        log.info("开始查询轮播图路径。。。");
        List<String> list = tUserService.findAllImage(category);
        List list1 = new ArrayList();
        for (String img : list)
        {
            String imgu = LocalNetUtils.natApp + img;
            //log.info(imgu);
            list1.add(imgu);
        }
        return list1;
    }

    @ResponseBody
    @RequestMapping(value = "/sendvideo", method = RequestMethod.GET)
    public List sendvideo()
    {
        List list = new ArrayList();
        list.add(LocalNetUtils.natApp + "/video/1571274045800.mp4");
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "/findAllXingzuo", method = RequestMethod.GET)
    public List findAllXingzuo(@RequestParam String name)
    {
        log.info("开始星座图路径。。。");
        List<String> list = tUserService.findAllXingzuo(name);
        List list1 = new ArrayList();
        for (String img : list)
        {
            String imgu = LocalNetUtils.natApp + img;
            log.info(imgu);
            list1.add(imgu);
        }
        return list1;
    }

    @ResponseBody
    @RequestMapping(value = "/findMusicList", method = RequestMethod.GET)
    public List<TMusic> findMusicList()
    {
        List<TMusic> list = tUserService.findMusicList();
        for (TMusic m : list)
        {
            String murl = m.getMurl();
            //log.info(murl);
            m.setMurl(LocalNetUtils.natApp + murl);//LocalNetUtils.natApp是调用其他类的静态常量
        }
        return list;
    }

    /**
     * 将小程序端头像上传至本地
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/uploadimg", method = RequestMethod.POST, consumes ="multipart/form-data")
    public String getFile(@RequestParam("fileimg") MultipartFile file)
    {
        log.info("收到请求");
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }

        String fileName = file.getOriginalFilename();
        log.info("文件名为："+fileName);
        String filePath = "C:\\ideaIU-2018.2.6.win\\workspace\\wxcx\\src\\main\\" +
                "resources\\static\\images\\tximg\\";
        File dest = new File(filePath + fileName);
        log.info("dest->"+dest);
        try {
            file.transferTo(dest);
            log.info("上传成功");
            return fileName;
        } catch (IOException e) {
            log.warn("上传失败");
            log.warn(e.getMessage());
        }
        return "上传失败！";
    }
}


/**
 * 发送当前时间绝对秒，精度为秒
 * 现在小程序内部已实现，此功能暂时作废
 *
 * @return
 * @ResponseBody
 * @RequestMapping(value = "/sentTimeStamp",method = RequestMethod.GET)
 * public Map<String,Object> sentTimeStamp(){
 * Map<String,Object> map=new HashMap<>();
 * //https://blog.csdn.net/lin_dianwei/article/details/54616014
 * long timeStampSec = System.currentTimeMillis()/1000;
 * String timestamp = String.format("%010d", timeStampSec);
 * log.info(timestamp);//获取当前绝对秒
 * map.put("timestampSec",timestamp);
 * return map;
 * }
 * <p>
 * 分页功能
 * @ResponseBody
 * @RequestMapping(value = "/pageInfo",method = RequestMethod.GET)
 * public PageInfo<TUser> toApplicationList(@RequestParam(value="pageNo",defaultValue="1")int pageNo,
 * @RequestParam(value="pageSize",defaultValue="5")int pageSize,
 * Model model){
 * <p>
 * return tUserService.findByPage(pageNo,pageSize);
 * }
 * <p>
 * 此项功能暂时废弃
 * @return
 */

/**
 * 分页功能

 @ResponseBody
 @RequestMapping(value = "/pageInfo",method = RequestMethod.GET)
 public PageInfo<TUser> toApplicationList(@RequestParam(value="pageNo",defaultValue="1")int pageNo,
 @RequestParam(value="pageSize",defaultValue="5")int pageSize,
 Model model){

 return tUserService.findByPage(pageNo,pageSize);
 }
 */

/**
 * 此项功能暂时废弃
 * @return
 */
//    @ResponseBody
//    @RequestMapping(value = "/sendImg",method = RequestMethod.GET)
//    public List sendImg(){
//       List list=new ArrayList();
//       list.add(imgUrl+"/images/tximg/xuejing.jpeg");
//       return list;
//    }