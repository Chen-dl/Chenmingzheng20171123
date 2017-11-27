package com.bawei.fanxinhua;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioGroup;

import com.bawei.fanxinhua.adapter.RadioGroupFragmentPagerAdapter;
import com.bawei.fanxinhua.fragment.Fragment1;
import com.bawei.fanxinhua.fragment.Fragment2;
import com.bawei.fanxinhua.fragment.Fragment3;
import com.bawei.fanxinhua.fragment.Fragment4;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity  implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener{
    @InjectView(R.id.viewPager)
    ViewPager viewPager;
    @InjectView(R.id.radioGroup)
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#0000c6"));//可以自定义状态栏颜色
        }
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //fragment放进集合
        List<Fragment> mList = new ArrayList<Fragment>();
        mList.add(new Fragment1());
        mList.add(new Fragment2());
        mList.add(new Fragment3());
        mList.add(new Fragment4());
        RadioGroupFragmentPagerAdapter adapter = new RadioGroupFragmentPagerAdapter(getSupportFragmentManager(),mList);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(this);
        radioGroup.setOnCheckedChangeListener(this);
        radioGroup.check(R.id.rb1);
    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }
    @Override
    public void onPageSelected(int position) {
        switch (position){
            case 0:
                radioGroup.check(R.id.rb1);
                break;
            case 1:
                radioGroup.check(R.id.rb2);
                break;
            case 2:
                radioGroup.check(R.id.rb3);
                break;
            case 3:
                radioGroup.check(R.id.rb4);
                break;
        }
    }
    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        switch (i){
            case R.id.rb1:
                viewPager.setCurrentItem(0);
                break;
            case R.id.rb2:
                viewPager.setCurrentItem(1);
                break;
            case R.id.rb3:
                viewPager.setCurrentItem(2);
                break;
            case R.id.rb4:
                viewPager.setCurrentItem(3);
                break;
        }
    }

}
