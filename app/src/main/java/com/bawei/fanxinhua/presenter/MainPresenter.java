package com.bawei.fanxinhua.presenter;

import com.bawei.fanxinhua.bean.MoviceBean;
import com.bawei.fanxinhua.model.MainModel;
import com.bawei.fanxinhua.view.MainView;

import retrofit2.Call;

/**
 * Created by dell on 2017/11/23.
 */

public class MainPresenter implements MainModel.IMainModel{
    private MainModel model;
    private MainView view;
  //  WeakReference<MainView> mainview;


    public MainPresenter(MainView view) {
     //   attach(view);
        this.view = view;
        model=new MainModel();
        model.setiMainModel(this);
    }

    public void adddata(){
        model.getData();
    }

    @Override
    public void getsuccess(MoviceBean msg) {
        view.success(msg);
    }

    @Override
    public void geterror(Call call) {

        view.error(call);
    }
//    public void attach(MainView view){
//        mainview= new WeakReference(view);
//    }
//    //解绑方法
//    public void detach(){
//        Log.d("sssss","sssssssssssssssssssssssssss");
//        mainview.clear();
//    }
}
