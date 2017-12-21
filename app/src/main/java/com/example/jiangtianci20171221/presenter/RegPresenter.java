package com.example.jiangtianci20171221.presenter;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.jiangtianci20171221.LoginActivity;
import com.example.jiangtianci20171221.app.OnUiCallback;
import com.example.jiangtianci20171221.bean.RegBean;
import com.example.jiangtianci20171221.model.ILoginModel;
import com.example.jiangtianci20171221.model.LoginModel;
import com.example.jiangtianci20171221.view.IRegView;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;



public class RegPresenter {

    Context context;
    IRegView view;
    ILoginModel model;

    public RegPresenter(Context context, IRegView view) {
        this.context = context;
        this.view = view;
        model = new LoginModel();
    }

    public void reg(){
        String name = view.getName();
        String pass = view.getPass();

        model.reg(name, pass, new OnUiCallback() {
            @Override
            public void onFailed(Call call, IOException e) {

            }

            @Override
            public void onSuccess(String result) throws IOException {

                RegBean rb = new Gson().fromJson(result,RegBean.class);

                String code = rb.getCode();
                Log.i("=========", "onSuccess: "+code);
                if(code.equals("0")){
                    Toast.makeText(context,"注册成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, LoginActivity.class);
                    context.startActivity(intent);
                }else{
                    Toast.makeText(context,"注册失败",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
