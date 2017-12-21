package com.example.jiangtianci20171221.presenter;

import android.util.Log;

import com.example.jiangtianci20171221.bean.DataBean;
import com.example.jiangtianci20171221.bean.MsgBean;
import com.example.jiangtianci20171221.model.Model;
import com.example.jiangtianci20171221.model.Model1;
import com.example.jiangtianci20171221.view.IView1;

import java.util.List;

/**
 * Created by 姜天赐 on 2017/12/21.
 */

public class Present implements IPresent{
    Model1 model1;
    IView1 iView1;

    public Present(IView1 iView1) {
        model1=new Model1();
        this.iView1 = iView1;
    }

    public void detachView() {
        if (iView1 != null) {
            iView1 = null;
        }
    }

    @Override
    public void delcont(String uid, String pid) {
        model1.delData(this,uid,pid);
    }

    @Override
    public void getcont(String uid) {
        model1.getData(this,uid);
    }

    @Override
    public void delData(MsgBean msgBean) {
        iView1.delSuccess(msgBean);
    }

    @Override
    public void getData(MsgBean<List<DataBean>> listMsgBean) {
        Log.i("===", "P_getData"+listMsgBean.toString());
        iView1.onSuccess(listMsgBean);
    }
}