package com.zrblog.cxf.restful.domain;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * @author zrblog
 * @version 1.0.0
 * @Description:
 * @date 2018/8/9 23:19
 */
@XmlRootElement(name = "Customer")
public class Customer {

    private String id;

    private String name;

    private Date birthday;

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
