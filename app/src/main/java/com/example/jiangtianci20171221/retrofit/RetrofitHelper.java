package com.example.jiangtianci20171221.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 姜天赐 on 2017/12/21.
 */

public class RetrofitHelper {
    public static OkHttpClient okHttpClient;
    static
    {
        initOkHttpClient();
    }

    public static OkHttpClient initOkHttpClient()
    {
        if(okHttpClient==null)
        {
            synchronized (RetrofitHelper .class)
            {
                if(okHttpClient==null)
                {
                    okHttpClient=new OkHttpClient();
                }
            }
        }
        return okHttpClient;
    }
    public static<T> T OnCreatApi(Class<T> tClass,String url)
    {

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(tClass);
    }
}
