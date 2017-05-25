package com.example.ziyulibrary.Adapter.MyAdapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * 多布局适配器
 * Created by zlc on 2016/9/19.
 */
public abstract class MyAbsMoreBaseAdapter<T> extends BaseAdapter {

    private List<T> list;
    private LayoutInflater mlayoutInflater;
    private List<Integer> layoutList;

    public MyAbsMoreBaseAdapter(Context context , List<Integer> layoutList){
        this.list = new ArrayList<>();
        this.mlayoutInflater = LayoutInflater.from(context);
        this.layoutList = layoutList;
    }

    public void addDatas(List<T> list){
        this.list.addAll(list);
        this.notifyDataSetChanged();
    }

    public void setDatas(List<T> list){
        this.list = list;
        this.notifyDataSetChanged();
    }

    public List<T> getDatas(){
        return this.list;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return bindViewType(position);
    }

    /**重写返回多部局编号  返回值设为layoutlist下标*/
    protected abstract int bindViewType(int position);

    @Override
    public int getViewTypeCount() {
        return layoutList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        int type = getItemViewType(position);//多布局返回类型
        if(convertView != null){
            viewHolder = (ViewHolder) convertView.getTag();
        }else{
            convertView = mlayoutInflater.inflate(layoutList.get(type),null); //依据布局类型inflate不同的layout type 与 list下标对应
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        bindView(viewHolder,list.get(position),type);
        return convertView;
    }

    public abstract void bindView(ViewHolder viewHolder, T data, int type);

    protected class ViewHolder{
        SparseArray<View> sparseArray = new SparseArray<>(); //缓存item控件的map集合
        View layoutView;   //item布局

        public ViewHolder(View layoutView){
            this.layoutView = layoutView;
        }
        public View getView(int id){
            View view = sparseArray.get(id);
            if(view == null){
                view = layoutView.findViewById(id);
                sparseArray.put(id,view);
            }
            return view;
        }

        public ViewHolder setText(int id, String value){
            TextView textView = (TextView)getView(id);
            textView.setText(value);
            return this;
        }

        public ViewHolder setImage(int id,String url){
            ImageView imageView = (ImageView)getView(id);
            Glide.with(imageView.getContext()).load(url).into(imageView);
            //new ImageLoader(imageView.getContext()).load(url).into(imageView).setMrImage(R.mipmap.ic_launcher).down();
            return this;
        }

    }

}
