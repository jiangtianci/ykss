package com.example.jiangtianci20171221.model;


import android.support.annotation.NonNull;
import android.util.Log;

import com.example.jiangtianci20171221.api.API1;
import com.example.jiangtianci20171221.api.ServiceApi;
import com.example.jiangtianci20171221.bean.DataBean;
import com.example.jiangtianci20171221.bean.MsgBean;
import com.example.jiangtianci20171221.presenter.IPresent;
import com.example.jiangtianci20171221.retrofit.RetrofitHelper;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 姜天赐 on 2017/12/21.
 */

public class Model1 implements Imodel1{
    @Override
    public void delData(final IPresent iPresent, String uid, String pid) {
        RetrofitHelper.OnCreatApi(ServiceApi.class, API1.HOST)
                .deleteData(uid,pid,"android")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MsgBean>() {


                    @Override
                    public void onNext(@NonNull MsgBean msgBean) {
                        iPresent.delData(msgBean);
                    }

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i("===", "delDataonError"+e.toString());
                    }


                });
    }

    @Override
    public void getData(final IPresent iPresent, String uid) {
        RetrofitHelper.OnCreatApi(ServiceApi.class, API1.HOST)
                .getDatas(uid,"android")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MsgBean<List<DataBean>>>() {

                    @Override
                    public void onNext(@NonNull MsgBean<List<DataBean>> listMsgBean) {
                        Log.i("===", "getData"+listMsgBean.toString());
                        iPresent.getData(listMsgBean);
                    }

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i("===", "getDataonError"+e.toString());
                    }


                });
    }
}