package com.zrblog.cxf.comparessdata.service;

import com.zrblog.cxf.comparessdata.daoain.BigData;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @author zrblog
 * @version 1.0.0
 * @Description:
 * @date 2018/8/12 10:09
 */
@WebService
public interface BigDataWebService {

    @WebMethod
    @WebResult
    BigData getBigDta(@WebParam String name, @WebParam int size);
}
