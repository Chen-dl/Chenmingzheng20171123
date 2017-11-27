package com.bawei.fanxinhua.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bawei.fanxinhua.R;
import com.bawei.fanxinhua.StarActivity;
import com.bawei.fanxinhua.adapter.Myadapter;
import com.bawei.fanxinhua.bean.MoviceBean;
import com.bawei.fanxinhua.presenter.MainPresenter;
import com.bawei.fanxinhua.utils.GlideImageLoader;
import com.bawei.fanxinhua.view.MainView;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

/**
 * Created by dell on 2017/11/23.
 */

public class Fragment1 extends Fragment implements MainView{
    private View view;
    private Banner banner;
    private RecyclerView recyclerView;
    private MainPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view=View.inflate(getActivity(), R.layout.item1,null);

        initView();
        return view;
    }

    //初始化控件
    private void initView() {
        recyclerView=view.findViewById(R.id.recyclerView);
        banner=view.findViewById(R.id.banner);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
         presenter=new MainPresenter(this);
        presenter.adddata();
    }

    /**
     * 请求成功
     * @param msg
     */
    @Override
    public void success(final MoviceBean msg) {
        Toast.makeText(getActivity(),msg.getCode(),Toast.LENGTH_SHORT).show();
        List<String> images=new ArrayList<>();
        for(int i=0;i<3;i++){
            images.add( msg.getRet().getList().get(3).getChildList().get(i).getPic());
        }
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(images);
        banner.start();
        Myadapter adapter=new Myadapter(msg.getRet().getList().get(0).getChildList(),getActivity());
        recyclerView.setAdapter(adapter);
        Log.d("ssg",msg.getRet().getList().get(1).getChildList().toString());
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Intent intent=new Intent(getActivity(), StarActivity.class);
                intent.putExtra("starurl",msg.getRet().getList().get(0).getChildList().get(position).getLoadURL());
                startActivity(intent);
            }
        });
        adapter.setOnItemClickListener(new Myadapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent=new Intent(getActivity(), StarActivity.class);
                intent.putExtra("starurl",msg.getRet().getList().get(0).getChildList().get(position).getLoadURL());
                startActivity(intent);
            }
        });
    }
    /**
     * 请求失败
     * @param msg
     */
    @Override
    public void error(Call call) {
        Toast.makeText(getActivity(),call.toString(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
     //   presenter.detach();
    }
}
