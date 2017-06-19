package com.example.niit.hotel.model;

import com.example.niit.hotel.activity.LoginActivity;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;

/**
 * Created by wangyejun on 2017/6/13.
 */

public class MyUser extends BmobUser {
    private String name;
    private String pwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}
