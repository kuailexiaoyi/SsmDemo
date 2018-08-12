package com.zrblog.cxf.comparessdata.service.impl;

import com.zrblog.cxf.comparessdata.daoain.BigData;
import com.zrblog.cxf.comparessdata.service.BigDataWebService;

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
public class BigDataWebServiceImpl implements BigDataWebService{


    @Override
    public BigData getBigDta(String name, int size) {
        BigData bigData = new BigData(name,size);
        return bigData;
    }
}
