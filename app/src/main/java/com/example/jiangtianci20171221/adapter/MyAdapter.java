package com.example.jiangtianci20171221.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jiangtianci20171221.R;
import com.example.jiangtianci20171221.bean.Bean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 姜天赐 on 2017/12/21.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    Context context;
    List<Bean.DataBean> list;
    private View view;
    private OnItemClickListener mOnItemClickListener = null;

    //define interface
    public static interface OnItemClickListener {
        void onItemClick(View view , int position);
    }
    public MyAdapter(Context context, List<Bean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        ((ViewHolder)holder).face.setImageURI(Uri.parse(list.get(position).images));

        ((ViewHolder)holder).title.setText(list.get(position).price+"");
        ((ViewHolder)holder).title.setText(list.get(position).title+"");
        String images = list.get(position).images;
        if (images != null) {
            String[] split = images.split("\\|");
            Uri uri = Uri.parse(split[0]);
            ((ViewHolder) holder).face.setImageURI(uri);
        }
        ((ViewHolder)holder).itemView.setTag(position);
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public SimpleDraweeView face;
        public TextView price;
        public TextView title;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.face = (SimpleDraweeView) rootView.findViewById(R.id.face);
            this.price = (TextView) rootView.findViewById(R.id.price);
            this.title = (TextView) rootView.findViewById(R.id.title);
        }

    }
}
