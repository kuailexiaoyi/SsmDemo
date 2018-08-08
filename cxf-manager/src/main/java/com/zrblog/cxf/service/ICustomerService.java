package com.zrblog.cxf.service;

import com.zrblog.cxf.domian.Customer;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @author zrblog
 * @version 1.0.0
 * @Description:
 * @date 2018/8/9 0:01
 */
@WebService(name = "customerService")
public interface ICustomerService {

    @WebMethod
    @WebResult Customer findCustomer(@WebParam String id);


}
