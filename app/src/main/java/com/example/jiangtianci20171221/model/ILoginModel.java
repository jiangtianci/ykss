package com.example.jiangtianci20171221.model;

import okhttp3.Callback;


public interface ILoginModel {
    void login(String name, String pass, Callback callback);
    void reg(String name, String pass, Callback callback);
}
