package com.zrblog.cxf.domian;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.Date;

/**
 * @author zrblog
 * @version 1.0.0
 * @Description:
 * @date 2018/8/8 23:40
 */
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

    @Override
    public String toString() {
       return ToStringBuilder.reflectionToString(this);
    }
}
