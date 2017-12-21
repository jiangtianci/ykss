package com.example.jiangtianci20171221.presenter;

import com.example.jiangtianci20171221.bean.Bean;
import com.example.jiangtianci20171221.model.Imodel;
import com.example.jiangtianci20171221.model.Model;
import com.example.jiangtianci20171221.model.OnClick;
import com.example.jiangtianci20171221.view.Iview;

import java.util.List;

/**
 * Created by 姜天赐 on 2017/12/21.
 */

public class Persenter implements Ipersenter {
    Imodel imodel;
    Iview iview;

    public Persenter(Iview iview) {
        this.iview = iview;
        this.imodel=new Model();
    }

    @Override
    public void loadlist(String url) {
        imodel.RequestData(url, new OnClick() {
            @Override
            public void Success(List<Bean.DataBean> list) {
                iview.Success(list);
            }
        });

    }
    public  void distory(){
        iview=null;
    }
}
