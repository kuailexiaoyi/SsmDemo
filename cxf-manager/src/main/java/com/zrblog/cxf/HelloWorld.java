package com.zrblog.cxf;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @author zrblog
 * @version 1.0.0
 * @Description:
 * @date 2018/8/8 0:19
 */
@WebService
public interface HelloWorld {

    @WebMethod
    @WebResult String say(@WebParam String str);
}
