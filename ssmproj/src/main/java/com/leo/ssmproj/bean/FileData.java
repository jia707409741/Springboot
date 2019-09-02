package com.leo.ssmproj.bean;

/**
 * 状态码：0表示成功，-1表示失败
 */
public class FileData
{
    private int code;

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    private String msg;

    public FileData(int code, String msg)
    {
        this.code = code;
        this.msg = msg;
    }

    private Object data;

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }
}
