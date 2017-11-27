package com.bawei.fanxinhua.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.fanxinhua.R;

/**
 * Created by dell on 2017/11/23.
 */

public class Fragment3 extends Fragment{
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view=View.inflate(getActivity(), R.layout.item3,null);

        return view;
    }
}
