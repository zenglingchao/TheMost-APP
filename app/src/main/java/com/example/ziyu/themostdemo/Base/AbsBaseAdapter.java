package com.example.ziyu.themostdemo.Base;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Ziyu on 2016/9/19.16:14
 * 单布局万能适配器
 */
public abstract class AbsBaseAdapter<T> extends BaseAdapter {

    protected Context context;
    protected List<T> datas;
    private int resid;

    public AbsBaseAdapter(Context context, int resid) {
        this.context = context;
        this.resid = resid;
        this.datas = new ArrayList<>();
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
        this.notifyDataSetChanged();
    }

    public void addDatas(List<T> datas) {
        this.datas.addAll(datas);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView != null) {
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(context).inflate(resid, parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }

        //给不同的控制设置值
        bindView(viewHolder, datas.get(position), position);
        return convertView;
    }

    public abstract void bindView(ViewHolder viewHolder, T data, int position);


    protected class ViewHolder {
        SparseArray<View> sparseArray = new SparseArray<>();

        View layoutView;

        public ViewHolder(View layoutView) {
            this.layoutView = layoutView;
        }

        public View getView(int id) {
            View view = sparseArray.get(id);
            if (view == null) {
                view = layoutView.findViewById(id);
                sparseArray.put(id, view);
            }
            return view;
        }


        public ViewHolder bindTextView(int id, String value) {
            TextView tv = (TextView) this.getView(id);
            tv.setText(value);
            return this;
        }

        public ViewHolder bindImageView(int id, String url, int defualid) {
            ImageView iv = (ImageView) this.getView(id);
            Glide.with(context)
                    .load(url)
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    //.placeholder(defualid)
                    // .thumbnail(0.5f)
                    // .crossFade()
                    .into(iv);
            return this;
        }
    }
}
