package com.example.niit.hotel.entity;

import cn.bmob.v3.BmobObject;

/**
 * Created by wangyejun on 2017/6/22.
 */

public class Cityentity extends BmobObject {
    private String cityname;


    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }
}
