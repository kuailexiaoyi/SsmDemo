package com.zrblog.cxf.main;

import com.zrblog.cxf.HelloWorld;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * @author zrblog
 * @version 1.0.0
 * @Description:
 * @date 2018/8/8 0:22
 */
public class CxfClientService {

    public static void main(String[] args) throws InterruptedException {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(HelloWorld.class);
        factory.setAddress("http://localhost:9000/ws/HelloWorld");
        HelloWorld helloworld = (HelloWorld) factory.create();
        System.out.println(helloworld.say("kongxx"));
        System.exit(0);
    }
}
