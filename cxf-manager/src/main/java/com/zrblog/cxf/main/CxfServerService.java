package com.zrblog.cxf.main;

import com.zrblog.cxf.impl.HelloWorldImpl;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
 * @author zrblog
 * @version 1.0.0
 * @Description:
 * @date 2018/8/8 0:22
 */
public class CxfServerService {

    public static void main(String[] args) throws InterruptedException {
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        factory.setServiceClass(HelloWorldImpl.class);

        factory.setAddress("http://localhost:9000/ws/HelloWorld");
        factory.create();

        System.out.println("Server start...");
        Thread.sleep(60 * 1000);
        System.out.println("Server exit...");
        System.exit(0);
    }
}
