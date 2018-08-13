package com.zrblog.cxf.transferfile.service.impl;

import com.zrblog.cxf.transferfile.domain.MyFile;
import com.zrblog.cxf.transferfile.service.FileTransferService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.Arrays;

/**
 * @author zrblog
 * @version 1.0.0
 * @Description:
 * @date 2018/8/12 23:02
 */
public class FileTransferServiceImpl implements FileTransferService{


    @Override
    public void uploadFile(MyFile myFile) {
        OutputStream os = null;

        long position = myFile.getPosition();

        try {
            if (position!=0){
                os = FileUtils.openOutputStream(new File(myFile.getServerFile()),true);
            }else {
                os = FileUtils.openOutputStream(new File(myFile.getServerFile()),false);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(os);
        }

    }

    @Override
    public MyFile dowloadFile(MyFile myFile) {
        InputStream is = null;

        try {
            is = new FileInputStream(myFile.getServerFile());

            is.skip(myFile.getPosition());

            byte[] bytes = new byte[1024];

            int size = is.read(bytes);

            if (size > 0){
                byte[] fixedBytes = Arrays.copyOfRange(bytes, 0, size);
                myFile.setBytes(fixedBytes);
            }else {
                myFile.setBytes(new byte[0]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(is);
        }
        return myFile;
    }
}
