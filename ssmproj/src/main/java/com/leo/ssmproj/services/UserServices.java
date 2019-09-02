package com.leo.ssmproj.services;

import com.leo.ssmproj.bean.User;

public interface UserServices
{
     User register(User user);

     User login(User user);
}
