package com.example.jiangtianci20171221.presenter;

import android.util.Log;

import com.example.jiangtianci20171221.bean.DataBean;
import com.example.jiangtianci20171221.bean.MsgBean;

import java.util.List;

/**
 * Created by 姜天赐 on 2017/12/21.
 */

public interface IPresent {
    void delcont(String uid,String pid);
    void getcont(String uid);
    void delData(MsgBean msgBean);
    void getData(MsgBean<List<DataBean>> listMsgBean);
}


