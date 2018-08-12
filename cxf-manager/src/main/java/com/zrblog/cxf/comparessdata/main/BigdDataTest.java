package com.zrblog.cxf.comparessdata.main;

import com.zrblog.cxf.comparessdata.daoain.BigData;
import com.zrblog.cxf.comparessdata.service.BigDataWebService;
import com.zrblog.cxf.comparessdata.service.impl.BigDataWebServiceImpl;
import junit.framework.Assert;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.transport.common.gzip.GZIPInInterceptor;
import org.apache.cxf.transport.common.gzip.GZIPOutInterceptor;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author zrblog
 * @version 1.0.0
 * @Description:
 * @date 2018/8/12 10:13
 */
public class BigdDataTest {

    private static final String address = "http://localhost:8080/ws/compress/bigDataService";

    @BeforeClass
    public static void setUpBeforeClass(){
        JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();

        factoryBean.getInInterceptors().add(new LoggingInInterceptor());

        factoryBean.getOutFaultInterceptors().add(new LoggingOutInterceptor());

        factoryBean.getInInterceptors().add(new GZIPInInterceptor());

        factoryBean.getOutFaultInterceptors().add(new GZIPOutInterceptor());

        factoryBean.setServiceClass(BigDataWebServiceImpl.class);

        factoryBean.setAddress(address);

        factoryBean.create();
    }

    @Test
    public void testBigData(){
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();

        factoryBean.setAddress(address);

        factoryBean.setServiceClass(BigDataWebService.class);

        Object object = factoryBean.create();

        Client client = ClientProxy.getClient(object);

        Endpoint endpoint = client.getEndpoint();

        endpoint.getInInterceptors().add(new GZIPInInterceptor());

        endpoint.getOutInterceptors().add(new GZIPOutInterceptor());

        BigDataWebService bigDataWebService = (BigDataWebService) object;
        Assert.assertNotNull(bigDataWebService);

        String name = "my big data";

        int size = 1024*1024;

        long start = System.currentTimeMillis();

        BigData bigData = bigDataWebService.getBigDta(name,size);

        long stop = System.currentTimeMillis();
        System.out.println("Time:"+(stop-start));

    }
}
