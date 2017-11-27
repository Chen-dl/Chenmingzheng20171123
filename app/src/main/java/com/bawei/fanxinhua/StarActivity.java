package com.bawei.fanxinhua;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.fanxinhua.bean.StarBean;
import com.bawei.fanxinhua.utils.HttpUtils;
import com.google.gson.Gson;

import butterknife.ButterKnife;
import butterknife.InjectView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class StarActivity extends AppCompatActivity {
    private JCVideoPlayerStandard jcVideoPlayerStandard;
     HttpUtils utils;
     String starurl;
    @InjectView(R.id.tv1)
    TextView tv1;
    @InjectView(R.id.tv2)
    TextView tv2;
    @InjectView(R.id.back)
    TextView back;
    @InjectView(R.id.t)
    TextView t;
    @InjectView(R.id.name)
    TextView name;

    //测试地址
    String s1="http://video.jiecao.fm/5/1/%E8%87%AA%E5%8F%96%E5%85%B6%E8%BE%B1.mp4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star);
        Intent intent = getIntent();
        ButterKnife.inject(this);
        starurl = intent.getStringExtra("starurl");
        jcVideoPlayerStandard= (JCVideoPlayerStandard) findViewById(R.id.jiecao_Player);
        //点击退出
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        utils=new HttpUtils();
        utils.getJson(starurl, new HttpUtils.HttpCallBack() {
            @Override
            public void onSusscess(String data) {
                Gson gson=new Gson();
                StarBean starBean = gson.fromJson(data, StarBean.class);
                String smoothURL = starBean.getRet().getSmoothURL();
                String title = starBean.getRet().getTitle();
                String neirong = starBean.getRet().getDescription();
                String jianjie = starBean.getRet().getActors();
                Log.d("ss",smoothURL);
                Toast.makeText(StarActivity.this,smoothURL,Toast.LENGTH_SHORT).show();
                jcVideoPlayerStandard.setUp(s1,JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,title);
                name.setText(neirong);
                t.setText(jianjie);
                tv1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });



            }
        });

    }
    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()){
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
