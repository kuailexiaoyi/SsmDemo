package com.zrblog.cxf.transferfile.domain;


/**
 * @author zrblog
 * @version 1.0.0
 * @Description:
 * @date 2018/8/12 23:00
 */
public class MyFile {

    private String clientFile;

    private String serverFile;

    private long position;

    private byte[] bytes;

    public String getClientFile() {
        return clientFile;
    }

    public void setClientFile(String clientFile) {
        this.clientFile = clientFile;
    }

    public String getServerFile() {
        return serverFile;
    }

    public void setServerFile(String serverFile) {
        this.serverFile = serverFile;
    }

    public long getPosition() {
        return position;
    }

    public void setPosition(long position) {
        this.position = position;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
