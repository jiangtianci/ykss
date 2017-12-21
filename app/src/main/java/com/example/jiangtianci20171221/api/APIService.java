package com.example.jiangtianci20171221.api;

import com.example.jiangtianci20171221.bean.Bean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by 姜天赐 on 2017/12/21.
 */

public interface APIService {
    @GET("product/getProducts?pscid=39&page=1")
    Observable<Bean> getdata();
}
