package com.zrblog.cxf.service.impl;

import com.zrblog.cxf.domian.Customer;
import com.zrblog.cxf.service.ICustomerService;

import java.util.Calendar;


/**
 * @author zrblog
 * @version 1.0.0
 * @Description:
 * @date 2018/8/9 0:03
 */
public class CustomerServiceImpl implements ICustomerService {
    @Override
    public Customer findCustomer(String id) {
        Customer customer = new Customer();
        customer.setId("customer_"+id);
        customer.setName("customer_name");
        customer.setBirthday(Calendar.getInstance().getTime());

        return customer;
    }
}
