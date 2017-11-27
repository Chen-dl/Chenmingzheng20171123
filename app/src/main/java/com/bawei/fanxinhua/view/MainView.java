package com.bawei.fanxinhua.view;

import com.bawei.fanxinhua.bean.MoviceBean;

import retrofit2.Call;

/**
 * Created by dell on 2017/11/23.
 */

public interface MainView {
    void success(MoviceBean msg);
    void error(Call call);
}
