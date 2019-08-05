package com.leo.login;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.leo.login.mapper")
public class LoginApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(LoginApplication.class, args);
    }
}
