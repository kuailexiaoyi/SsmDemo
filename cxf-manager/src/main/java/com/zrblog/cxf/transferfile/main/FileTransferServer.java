package com.zrblog.cxf.transferfile.main;

import com.zrblog.cxf.transferfile.service.impl.FileTransferServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * @author zrblog
 * @version 1.0.0
 * @Description:
 * @date 2018/8/12 23:12
 */
public class FileTransferServer {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/ws/jaxws/fileTransferService", new FileTransferServiceImpl());
    }
}
