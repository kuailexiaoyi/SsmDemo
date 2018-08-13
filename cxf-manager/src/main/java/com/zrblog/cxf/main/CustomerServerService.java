package com.zrblog.cxf.main;

import com.zrblog.cxf.interceptor.ArtifactOutInterceptor;
import com.zrblog.cxf.interceptor.CAbstractPhaseInterceptor;
import com.zrblog.cxf.service.impl.CustomerServiceImpl;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
 * @author zrblog
 * @version 1.0.0
 * @Description:
 * @date 2018/8/9 0:06
 */
public class CustomerServerService {

    private static final String address = "http://localhost:8080/ws/jaxws/customerService";

    public static void main(String[] args) {
        JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();
//        factoryBean.getInInterceptors().add(new LoggingInInterceptor());
//        factoryBean.getOutInterceptors().add(new LoggingOutInterceptor());
        factoryBean.getInInterceptors().add(new CAbstractPhaseInterceptor("receive"));
        factoryBean.getOutInterceptors().add(new ArtifactOutInterceptor());

        factoryBean.setServiceClass(CustomerServiceImpl.class);

        factoryBean.setAddress(address);

        factoryBean.create();

    }
}
