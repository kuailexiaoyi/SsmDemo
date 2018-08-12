package com.zrblog.cxf.security.main;

import com.zrblog.cxf.security.doamin.User;
import com.zrblog.cxf.security.handler.UserClientHandler;
import com.zrblog.cxf.security.handler.UserServerHandler;
import com.zrblog.cxf.security.service.UserService;
import com.zrblog.cxf.security.service.impl.UserServiceImpl;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zrblog
 * @version 1.0.0
 * @Description:
 * @date 2018/8/12 10:13
 */
public class UserServiceSecurityTest {

    private static final String address = "http://localhost:8080/ws/security/userService";

    @BeforeClass
    public static void setUpBeforeClass(){
        JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();

        factoryBean.getInInterceptors().add(new LoggingInInterceptor());

        factoryBean.getOutFaultInterceptors().add(new LoggingOutInterceptor());

        HashMap<String, Object> map = new HashMap<>();
        map.put("action", "UsernameToken");
        map.put("passwordType", "PasswordText");
        map.put("passwordCallbackClass", UserServerHandler.class.getName());


        WSS4JInInterceptor wss4JInInterceptor  = new WSS4JInInterceptor(map);
        factoryBean.getInInterceptors().add(wss4JInInterceptor);
        factoryBean.setAddress(address);


        factoryBean.setServiceClass(UserServiceImpl.class);

        factoryBean.setAddress(address);

        factoryBean.create();
    }

    @Test
    public void testBigData(){
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();

        factoryBean.setAddress(address);

        factoryBean.setServiceClass(UserService.class);

        Object object = factoryBean.create();

        Client client = ClientProxy.getClient(object);
        Endpoint endpoint = client.getEndpoint();

        Map<String, Object> map = new HashMap<String,Object>();
        map.put(WSHandlerConstants.ACTION,WSHandlerConstants.USERNAME_TOKEN);
        map.put(WSHandlerConstants.USER,"admin");
        map.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
        map.put(WSHandlerConstants.PW_CALLBACK_CLASS, UserClientHandler.class.getName());
        WSS4JOutInterceptor outInterceptor = new WSS4JOutInterceptor(map);
        endpoint.getOutInterceptors().add(outInterceptor);

        HTTPConduit conduit = (HTTPConduit) client.getConduit();
        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
        httpClientPolicy.setConnectionTimeout(5 * 1000);
        httpClientPolicy.setReceiveTimeout(5*1000);
        conduit.setClient(httpClientPolicy);


        UserService userService = (UserService) object;

        List<User> resultList = userService.getUser();

        System.out.println(resultList);
    }
}
