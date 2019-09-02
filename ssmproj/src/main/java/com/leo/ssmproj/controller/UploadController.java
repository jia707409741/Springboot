package com.leo.ssmproj.controller;


import com.leo.ssmproj.bean.FileData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/utils")
public class UploadController
{
    //文件路径最后一定要再加个/
    private static final String filePath="C:/ideaIU-2018.2.6.win/workspace/" +
            "findlogin/src/main/resources/static/images/";
    private static final org.slf4j.Logger log=org.slf4j.LoggerFactory.getLogger(UploadController.class);
    @RequestMapping("/upload")
    public FileData upload(@RequestParam("upload_img")MultipartFile file, HttpServletRequest request)
    {
        //获取表单提交的name
        String name = request.getParameter("name");
        log.info("name=" + name);

        //获取提交的文件名
        String fileName = file.getOriginalFilename();
        log.info("fileName=" + fileName);

        //获取文件名后缀
        String suffixName = fileName.substring(fileName.lastIndexOf("."));

        //转换后的文件名
        fileName = UUID.randomUUID() + suffixName;
        log.info("转换后的文件名为："+fileName);

        File dest=new File(filePath+fileName);
        try
        {
            file.transferTo(dest);
            return new FileData(0,fileName);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (IllegalStateException e){
            e.printStackTrace();
        }
        return new FileData(-1,"文件上传失败！");
    }
}
