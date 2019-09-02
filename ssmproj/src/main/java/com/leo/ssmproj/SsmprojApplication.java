package com.leo.ssmproj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.leo.ssmproj.dao")
public class SsmprojApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(SsmprojApplication.class, args);
    }
}
