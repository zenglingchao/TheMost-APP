package com.example.ziyulibrary.Base;

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
 * Created by Ken on 2016/9/27.14:59
 */
public abstract class AbsMoreBaseAdapter<T extends AbsMoreBaseAdapter.OnType> extends BaseAdapter{

    protected Context context;
    protected List<T> datas;
    private int[] resids;//如果布局的返回类型为0，则会采用resids[0]所对应的布局

    public AbsMoreBaseAdapter(Context context, int... resids){
        this.context = context;
        this.resids = resids;
        this.datas = new ArrayList<>();
    }

    public void setDatas(List<T> datas){
        this.datas = datas;
        this.notifyDataSetChanged();
    }

    public void addDatas(List<T> datas){
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
        if(convertView != null){
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(context).inflate(resids[getItemViewType(position)], null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }

        bindData(viewHolder, datas.get(position), getItemViewType(position),position);
        return convertView;
    }

    protected abstract void bindData(ViewHolder viewHolder, T data, int typeView, int position);

    protected class ViewHolder{
        SparseArray<View> sparseArray = new SparseArray<>();
        View layoutView;
        public ViewHolder(View layoutView){
            this.layoutView = layoutView;
        }

        public View getView(int id){
            View view = sparseArray.get(id);
            if(view == null){
                view = layoutView.findViewById(id);
                sparseArray.put(id, view);
            }
            return view;
        }


        public ViewHolder bindTextView(int id, String value){
            TextView tv = (TextView) this.getView(id);
            tv.setText(value);
            return this;
        }

        public ViewHolder bindImageView(int id, String url, int defualid){
            ImageView iv = (ImageView) this.getView(id);
            Glide.with(context)
                    .load(url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(defualid)
                    .thumbnail(0.1f)
                    .crossFade()
                    .into(iv);
            return this;
        }
    }

    /**
     * 返回item的布局类型 从0开始依次递增
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        OnType onType = datas.get(position);
        return onType.getType();
    }

    @Override
    public int getViewTypeCount() {
        return resids.length;
    }

    public interface OnType{
        int getType();
    }
}
