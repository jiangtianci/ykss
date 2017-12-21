package com.example.jiangtianci20171221.view;

import com.example.jiangtianci20171221.bean.DataBean;
import com.example.jiangtianci20171221.bean.MsgBean;

import java.util.List;

/**
 * Created by 姜天赐 on 2017/12/21.
 */

public interface IView1 {
    void onSuccess(MsgBean<List<DataBean>> listMsgBean);
    void onFailed(Exception e);
    void delSuccess(MsgBean msgBean);
}
