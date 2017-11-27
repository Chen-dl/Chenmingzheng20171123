package com.bawei.fanxinhua.adapter;

/**
 * Created by dell on 2017/11/23.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Kodulf on 2016/3/14.
 */
public class RadioGroupFragmentPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> list;

    //创建的构造方法一定要包含List<Fragment>的参数，
    //FragmentManager 一定要是v4包里面的
    public RadioGroupFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
