package com.leo.wxcx.bean;

import com.leo.wxcx.utils.LocalNetUtils;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName TImage
 * @Description: TODO
 * @Author lenovo
 * @Date 2019/11/1
 * @Version V1.0
 **/
@Data
public class TImage implements Serializable
{
    private int id;
    private String name;
    private String url;
}
