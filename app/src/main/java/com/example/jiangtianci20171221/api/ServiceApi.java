package com.example.jiangtianci20171221.api;

import com.example.jiangtianci20171221.bean.DataBean;
import com.example.jiangtianci20171221.bean.MsgBean;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 姜天赐 on 2017/12/21.
 */

public interface ServiceApi {
    @GET("product/getCarts")
    Observable<MsgBean<List<DataBean>>> getDatas(@Query("uid") String uid, @Query("source") String source);
    @GET("product/deleteCart")
    Observable<MsgBean> deleteData(@Query("uid") String uid, @Query("pid") String pid, @Query("source") String source);
}
