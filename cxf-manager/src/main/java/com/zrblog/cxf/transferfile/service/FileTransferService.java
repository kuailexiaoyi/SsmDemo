package com.zrblog.cxf.transferfile.service;

import com.zrblog.cxf.transferfile.domain.MyFile;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author zrblog
 * @version 1.0.0
 * @Description:
 * @date 2018/8/12 23:02
 */
@WebService
public interface FileTransferService {

    @WebMethod
    void uploadFile(MyFile myFile);

    @WebMethod
    MyFile dowloadFile(MyFile myFile);

}
