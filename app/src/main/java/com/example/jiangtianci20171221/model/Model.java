package com.example.jiangtianci20171221.model;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.jiangtianci20171221.api.API;
import com.example.jiangtianci20171221.api.APIService;
import com.example.jiangtianci20171221.api.ServiceApi;
import com.example.jiangtianci20171221.bean.Bean;
import com.example.jiangtianci20171221.bean.DataBean;
import com.example.jiangtianci20171221.bean.MsgBean;
import com.example.jiangtianci20171221.presenter.IPresent;
import com.example.jiangtianci20171221.retrofit.RetrofitHelper;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 姜天赐 on 2017/12/21.
 */

public class Model implements Imodel {
    @Override
    public void RequestData(String url, final OnClick onClick) {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        APIService apiService = retrofit.create(APIService.class);
        Observable<Bean> getdata = apiService.getdata();
        getdata.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        List<Bean.DataBean> data = bean.data;
                        onClick.Success(data);
                    }
                });
    }


}
