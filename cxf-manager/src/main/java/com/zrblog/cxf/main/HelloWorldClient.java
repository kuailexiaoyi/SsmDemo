package com.zrblog.cxf.main;

import com.zrblog.cxf.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zrblog
 * @version 1.0.0
 * @Description:
 * @date 2018/8/8 7:40
 */
public class HelloWorldClient {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        HelloWorld helloworld = (HelloWorld)context.getBean("helloworldClient");
        System.out.println(helloworld.say("zrblog"));
    }
}
