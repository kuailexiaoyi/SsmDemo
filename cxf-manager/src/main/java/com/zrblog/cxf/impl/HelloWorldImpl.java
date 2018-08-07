package com.zrblog.cxf.impl;

import com.zrblog.cxf.HelloWorld;

/**
 * @author zrblog
 * @version 1.0.0
 * @Description:
 * @date 2018/8/8 0:20
 */
public class HelloWorldImpl implements HelloWorld {
    @Override
    public String say(String str) {
        String msg  = "Hello World,"+str;
        return msg;
    }
}
