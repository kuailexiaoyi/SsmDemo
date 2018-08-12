package com.zrblog.cxf.security.service.impl;

import com.zrblog.cxf.security.doamin.User;
import com.zrblog.cxf.security.service.UserService;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zrblog
 * @version 1.0.0
 * @Description:
 * @date 2018/8/12 10:53
 */
@WebService
public class UserServiceImpl implements UserService{
    @Override
    public List<User> getUser() {
        List<User> userList = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i+"");
            user.setName("name-"+i);
            user.setPassword("password-"+i);
            userList.add(user);
        }
        return userList;
    }
}
