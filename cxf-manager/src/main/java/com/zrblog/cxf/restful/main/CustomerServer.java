package com.zrblog.cxf.restful.main;

import com.zrblog.cxf.restful.service.CustomerServiceImpl;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

/**
 * @Description: Restful风格的的webservice服务
 * @author zrblog
 * @version 1.0.0
 * @date 2018/8/9 23:28
 */
public class CustomerServer {

    public static void main(String[] args) {
        String address =  "http://localhost:8080/ws/jaxrs/";

        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();

        factoryBean.getInInterceptors().add(new LoggingInInterceptor());
        factoryBean.getInInterceptors().add(new LoggingOutInterceptor());

        factoryBean.setResourceClasses(CustomerServiceImpl.class);

        factoryBean.setAddress(address);

        factoryBean.create();
    }
}
