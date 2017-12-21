package com.example.jiangtianci20171221.presenter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.jiangtianci20171221.MainActivity;
import com.example.jiangtianci20171221.app.OnUiCallback;
import com.example.jiangtianci20171221.bean.LoginBean;
import com.example.jiangtianci20171221.model.ILoginModel;
import com.example.jiangtianci20171221.model.LoginModel;
import com.example.jiangtianci20171221.view.ILoginView;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;



public class LoginPresenter {

    Context context;
    ILoginModel model;
    ILoginView view;

    public LoginPresenter(Context context, ILoginView view) {
        this.context = context;
        this.view = view;
        model = new LoginModel();
    }

    // 登录的方法
    public void login(){
        String name = view.getName();
        String pass = view.getPass();
        model.login(name, pass, new OnUiCallback() {
            @Override
            public void onFailed(Call call, IOException e) {

            }

            @Override
            public void onSuccess(String result) throws IOException {

                LoginBean lb = new Gson().fromJson(result,LoginBean.class);
                String code = lb.getCode();
                Log.i("=========", "onSuccess: "+code);
                if(code.equals("0")){

                    Toast.makeText(context,"登录成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, MainActivity.class);
                    context.startActivity(intent);
                }else{
                    Toast.makeText(context,"登录失败",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
