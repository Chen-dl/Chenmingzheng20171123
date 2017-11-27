package com.bawei.fanxinhua.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bawei.fanxinhua.R;
import com.bawei.fanxinhua.bean.MoviceBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by dell on 2017/11/23.
 */


public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {
   public List<MoviceBean.RetBean.ListBean.ChildListBean> list;
    public Context context;
    private OnItemClickListener mOnItemClickListener;

    public Myadapter(List<MoviceBean.RetBean.ListBean.ChildListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }
    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_item,viewGroup,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }
    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {
       viewHolder.title.setText(list.get(position).getTitle());
        Uri uri =  Uri.parse(list.get(position).getPic());

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        viewHolder.img.setController(controller);
        if(mOnItemClickListener!=null){
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = viewHolder.getPosition(); // 1
                    mOnItemClickListener.onItemClick(viewHolder.itemView,position); // 2
                }
            });


        }

    }
    //获取数据的数量
    @Override
    public int getItemCount() {
        return list.size();
    }
    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public SimpleDraweeView img;
        public ViewHolder(View view){
        super(view);
            img =  view.findViewById(R.id.img);
            title=view.findViewById(R.id.title);
        }



    }
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

}
