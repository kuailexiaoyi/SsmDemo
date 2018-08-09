package com.zrblog.cxf.restful.main;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.IOException;

/**
 * @Description: Restful风格的的webservice服务
 * @author zrblog
 * @version 1.0.0
 * @date 2018/8/9 23:28
 */
public class CustomerClient {

    public static void main(String[] args) throws IOException {
        String url = "http://localhost:8080/ws/jaxrs/customer/1/info";
        sendGetRequest(url);

        String url2 = "http://localhost:8080/ws/jaxrs/customer/search?name=abc";
        sendGetRequest(url2);
    }

    public static void sendGetRequest(String url) throws IOException {
        HttpClient httpclient = new HttpClient();
        GetMethod getMethod = new GetMethod(url);
        int code = httpclient.executeMethod(getMethod);
        if (code != HttpStatus.SC_OK){
            System.out.println("Method failed:"+getMethod.getStatusLine());
        }

        byte[] resultByte = getMethod.getResponseBody();

        System.out.println(new String(resultByte));
    }
}
