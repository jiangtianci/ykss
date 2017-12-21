package com.example.jiangtianci20171221.model;

import com.example.jiangtianci20171221.presenter.IPresent;

/**
 * Created by 姜天赐 on 2017/12/21.
 */

public interface Imodel1 {
    void delData(IPresent iPresent, String uid, String pid);
    void getData(IPresent iPresent, String uid);
}
