package com.zrblog.cxf.main;

import com.zrblog.cxf.domian.Customer;
import com.zrblog.cxf.service.ICustomerService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import javax.xml.ws.WebServiceException;
import java.net.SocketTimeoutException;

/**
 * @author zrblog
 * @version 1.0.0
 * @Description:
 * @date 2018/8/9 0:06
 */
public class CustomerClientService {

    private static final String address = "http://localhost:8080/ws/jaxws/customerService";

    public static void main(String[] args) {
        try {

            //调用WebService 接口
            JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();

            factoryBean.setAddress(address);

            factoryBean.setServiceClass(ICustomerService.class);

            Object object = factoryBean.create();


            ICustomerService customerService = (ICustomerService) object;

            Customer customer = customerService.findCustomer("lisi");

            System.out.println("Customer:"+customer);
        } catch (Exception e) {
            if (e instanceof WebServiceException
                    && e.getCause() instanceof SocketTimeoutException) {
                System.err.println("This is timeout exception.");
            } else {
                e.printStackTrace();
            }
        }

    }
}
