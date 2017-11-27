package com.bawei.fanxinhua.model;

/**
 * Created by dell on 2017/11/23.
 */

import com.bawei.fanxinhua.bean.MoviceBean;
import com.bawei.fanxinhua.netinterfece.RetrofitInterface;
import com.bawei.fanxinhua.utils.RetrofitUtils;
import retrofit2.Call;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainModel {
    private IMainModel iMainModel;

    public void setiMainModel(IMainModel iMainModel) {
        this.iMainModel = iMainModel;
    }

    public void getData(){

        RetrofitInterface requestServes = RetrofitUtils.doHttpDeal(RetrofitInterface.BASE_URL);
        requestServes.getstring().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MoviceBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        //  iMainModel.geterror(e);
                    }

                    @Override
                    public void onNext(MoviceBean userBean) {
                        iMainModel.getsuccess(userBean);
                    }
                });
    }

    public interface IMainModel{
        void getsuccess(MoviceBean msg);
        void geterror(Call call);
    }
}