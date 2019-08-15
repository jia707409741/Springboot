package com.leo.findlogin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.leo.findlogin.dao")
public class FindloginApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(FindloginApplication.class, args);
    }

}
