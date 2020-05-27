package com.fanhanfei.springstudy.beanload.model;

/**
 * @author zhangjunshuai
 * @date 2020/5/27
 * @description
 **/
//@Super
public class SuperUser extends User {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
