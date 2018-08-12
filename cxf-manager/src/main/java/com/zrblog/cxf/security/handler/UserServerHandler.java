package com.zrblog.cxf.security.handler;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zrblog
 * @version 1.0.0
 * @Description: 创建一个基于WS-Security标准的安全验证(CXF回调函数使用)
 * @date 2018/8/12 10:57
 */
public class UserServerHandler implements CallbackHandler {

    private Map<String,String> user;

    public UserServerHandler(){
        user = new HashMap<String,String>();
        user.put("admin","admin");
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        WSPasswordCallback callback = (WSPasswordCallback) callbacks[0];
        String id = callback.getIdentifier();
        //重要：用户名需要自己校验判断,多用户
        if (user.containsKey(id)){
            //设置密码，校验机制会将这个密码和客户端的密码做比较
            //新版本不需要写校验逻辑，API自动校验，只需要设置校验的密码
            // set the password on the callback. This will be compared to the password which was sent from the client.
            callback.setPassword("admin");
        }else {
            throw new SecurityException("Invalid User");
        }

    }
}
