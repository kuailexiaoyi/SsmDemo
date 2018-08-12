package com.zrblog.cxf.security.doamin;


/**
 * @author zrblog
 * @version 1.0.0
 * @Description:
 * @date 2018/8/12 10:50
 */
public class User {

    private String id;
    private String name;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
