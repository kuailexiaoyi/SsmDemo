package com.zrblog.cxf.security.handler;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

/**
 * @author zrblog
 * @version 1.0.0
 * @Description:
 * @date 2018/8/12 10:57
 */
public class UserClientHandler implements CallbackHandler {

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        WSPasswordCallback callback = (WSPasswordCallback) callbacks[0];
        int usage = callback.getUsage();
        System.out.println("identifier:"+callback.getIdentifier());
        System.out.println("usage:"+usage);

        if (usage == WSPasswordCallback.USERNAME_TOKEN){
            callback.setPassword("admin");
        }
    }
}
