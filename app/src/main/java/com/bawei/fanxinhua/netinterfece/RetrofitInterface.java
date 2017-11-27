package com.bawei.fanxinhua.netinterfece;


import com.bawei.fanxinhua.bean.MoviceBean;

import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by dell on 2017/11/23.
 */

    public interface RetrofitInterface {

        public static final String BASE_URL = "http://api.svipmovie.com/front/";

        // https://www.zhaoapi.cn/?mobile=13691032315&password=123456
        @POST("homePageApi/homePage.do")
        Observable<MoviceBean> getstring();

    }

