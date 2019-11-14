package com.leo.wxcx.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName TUser
 * @Description: TODO
 * @Author Leo
 * @Date 2019/10/24
 * @Version V1.0
 **/
@Data
public class TUser implements Serializable
{
    private int id;
    private String name;
    private int age;
    private String pwd;
    private String sex;
    private String imageurl;
}
