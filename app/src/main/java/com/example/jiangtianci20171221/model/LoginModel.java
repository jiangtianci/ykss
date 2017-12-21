package com.example.jiangtianci20171221.model;

import com.example.jiangtianci20171221.app.OkHttpUtils;

import okhttp3.Callback;


public class LoginModel implements ILoginModel {
    @Override
    public void login(String name, String pass, Callback callback) {
        OkHttpUtils.getInstance().doGet("http://120.27.23.105/user/login?mobile="+name+"&password="+pass,callback);
    }

    @Override
    public void reg(String name, String pass, Callback callback) {
        OkHttpUtils.getInstance().doGet("http://120.27.23.105/user/reg?mobile="+name+"&password="+pass,callback);
    }
}
