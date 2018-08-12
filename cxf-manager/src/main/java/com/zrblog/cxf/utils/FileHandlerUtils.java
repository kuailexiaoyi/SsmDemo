package com.zrblog.cxf.utils;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @author zrblog
 * @version 1.0.0
 * @Description:
 * @date 2018/8/10 8:05
 */
public class FileHandlerUtils {

    public  static boolean  decompressZip(File originFile, String targetDir){

        ZipFile zipFile = null;
        try {
            zipFile =  new ZipFile(originFile);
            ZipEntry zipEntry;

            Enumeration<? extends ZipEntry> entries = zipFile.entries();

            while (entries.hasMoreElements()){
                zipEntry = entries.nextElement();

                String fileName = zipEntry.getName();

                File outputFile = new File(targetDir+fileName);

                if (zipEntry.isDirectory()){

                }else if (!outputFile.getParentFile().exists()){

                }

                OutputStream outputStream = new FileOutputStream(outputFile);

                InputStream inputStream = zipFile.getInputStream(zipEntry);

                int len;
                byte[] buffer = new byte[1024];
                while ((len = inputStream.read(buffer))!=-1){
                    outputStream.write(buffer,0,len);
                }

                outputStream.close();
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            try {
                if (zipFile!=null){
                    zipFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return false;
    }
}
