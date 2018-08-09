package com.zrblog.cxf.restful.service;

import com.zrblog.cxf.restful.domain.Customer;

import java.util.Calendar;

/**
 * @author zrblog
 * @version 1.0.0
 * @Description:
 * @date 2018/8/9 23:24
 */

public class CustomerServiceImpl implements ICustomerService {
    @Override
    public Customer findCustomerById(String id) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName("name_"+id);
        customer.setBirthday(Calendar.getInstance().getTime());
        return customer;
    }

    @Override
    public Customer findCustomerByName(String name) {
        Customer customer = new Customer();
        customer.setId("id_"+name);
        customer.setName(name);
        customer.setBirthday(Calendar.getInstance().getTime());
        return customer;
    }
}
