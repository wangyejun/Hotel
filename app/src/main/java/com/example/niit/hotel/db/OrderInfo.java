package com.example.niit.hotel.db;

import org.litepal.crud.DataSupport;

/**
 * Created by wangyejun on 2017/6/22.
 */

public class OrderInfo extends DataSupport {

    private String city;
    private String inTime;
    private String outTime;
    private String addr;
    private String price;


    public OrderInfo() {
    }

    public OrderInfo(String city, String inTime, String outTime, String addr, String price) {
        this.city = city;
        this.inTime = inTime;
        this.outTime = outTime;
        this.addr = addr;
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "city='" + city + '\'' +
                ", inTime='" + inTime + '\'' +
                ", outTime='" + outTime + '\'' +
                ", addr='" + addr + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
