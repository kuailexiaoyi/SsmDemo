package com.zrblog.cxf.comparessdata.daoain;


/**
 * @author zrblog
 * @version 1.0.0
 * @Description:
 * @date 2018/8/12 10:06
 */
public class BigData {

    String name;

    String data;

    public BigData(){

    }

    public BigData(String name,int size){
        this.name = name;
        StringBuilder builder = new StringBuilder();

        for (int i = 0;i<size;i++){
            builder.append("bigdata"+i);
        }
        this.data = builder.toString();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BigData{" +
                "name='" + name + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
