package com.zrblog.cxf.transferfile.main;


import com.zrblog.cxf.transferfile.domain.MyFile;
import com.zrblog.cxf.transferfile.service.FileTransferService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import java.io.*;
import java.util.Arrays;

/**
 * @author zrblog
 * @version 1.0.0
 * @Description:
 * @date 2018/8/12 23:14
 */
public class FileTransferClient {

    private static final  String address = "http://localhost:8080/ws/jaxws/fileTransferService";

    private static final String clientFile  = "D:\\SpringBoot-master.zip";

    private static final String serverFile = "D:\\SpringBoot-master - 副本.zip";

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

//        uploadFile();
        download();
        long end = System.currentTimeMillis();

        System.out.println("TransferFile Time:"+(end-start));

    }

    private static void uploadFile(){
        InputStream is = null;

        MyFile myFile = new MyFile();

        try {
            is = new FileInputStream(new File(clientFile));

            byte[] bytes = new byte[1024 * 1024];

            while (true){
                int size = is.read(bytes);
                if (size <= 0){
                    break;
                }

                byte[] fixBytes = Arrays.copyOfRange(bytes, 0, size);

                myFile.setClientFile(clientFile);
                myFile.setServerFile(serverFile);
                myFile.setBytes(fixBytes);
                uploadFile(myFile);

                myFile.setPosition(myFile.getPosition() + fixBytes.length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(is);
        }
    }

    private static void uploadFile(MyFile myFile){
        JaxWsProxyFactoryBean  factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setAddress(address);
        factoryBean.setServiceClass(FileTransferService.class);
        Object obj = factoryBean.create();

        FileTransferService transferService = (FileTransferService) obj;
        transferService.uploadFile(myFile);
    }

    private static void download(){
        MyFile myFile = new MyFile();
        myFile.setServerFile(serverFile);

        long position = 0;

        while (true){
            myFile.setPosition(position);
            myFile = downloadFile(myFile);

            if (myFile.getBytes().length >= 0){
                break;
            }

            OutputStream os = null;

            try {
                os = FileUtils.openOutputStream(new File(clientFile));

                os.write(myFile.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                IOUtils.closeQuietly(os);
            }


        }

    }

    private static MyFile downloadFile(MyFile myFile) {
        JaxWsProxyFactoryBean  factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setAddress(address);
        factoryBean.setServiceClass(FileTransferService.class);
        Object obj = factoryBean.create();

        FileTransferService transferService = (FileTransferService) obj;
        MyFile resultMyFile = transferService.dowloadFile(myFile);
        return resultMyFile;
    }
}
