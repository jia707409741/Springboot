package com.leo.login.domain;

import java.io.Serializable;

/**
 * 用户表
 * 实现Serializable 实现序列化
 */
public class Users
{

  private Integer id;
  private String sname;
  private String spwd;
  private String userdesc;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getSname() {
    return sname;
  }

  public void setSname(String sname) {
    this.sname = sname;
  }


  public String getSpwd() {
    return spwd;
  }

  public void setSpwd(String spwd) {
    this.spwd = spwd;
  }


  public String getUserdesc() {
    return userdesc;
  }

  public void setUserdesc(String userdesc) {
    this.userdesc = userdesc;
  }

}
