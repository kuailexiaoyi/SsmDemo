package com.zrblog.cxf.security.service;

import com.zrblog.cxf.security.doamin.User;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

/**
 * @author zrblog
 * @version 1.0.0
 * @Description:
 * @date 2018/8/12 10:53
 */
@WebService
public interface UserService {
    @WebMethod
    @WebResult  List<User> getUser();
}
