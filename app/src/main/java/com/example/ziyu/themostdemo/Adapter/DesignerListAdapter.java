package com.example.ziyu.themostdemo.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.ziyu.themostdemo.DB.DataBaseUtil;
import com.example.ziyu.themostdemo.Entity.DesignerEntity;
import com.example.ziyu.themostdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ziyu on 2016/11/1.
 */

public class DesignerListAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<DesignerEntity.DataBean.DesignersBean> datas;
    private DesignerListAdapter.OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(DesignerListAdapter.OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public DesignerListAdapter(Context context) {
        this.context = context;
        this.datas = new ArrayList<>();
    }

    public int getDesignerId(int position){
        return datas.get(position).getId();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == 1){
            /**
             * 返回一个底部刷新布局
             */
            return new RefershViewholder(LayoutInflater.from(context).inflate(R.layout.item_load_footer,parent,false));
        }
        return new MyViewHoler(LayoutInflater.from(context).inflate(R.layout.item_designer, parent, false));

    }

    public void addDatas(List<DesignerEntity.DataBean.DesignersBean> datas) {
        /**
         * 添加到footer之前
         */
        this.datas.addAll(getItemCount()-1,datas);
        this.notifyDataSetChanged();
    }

    public void setDatas(List<DesignerEntity.DataBean.DesignersBean> datas) {
        this.datas = datas;
        this.notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        Log.d("print", "onBindViewHolder: " + position);
        /**
         * 刷新Item时直接触发回调
         */
        if(getItemViewType(position) == 1){
            Log.d("print", "onBindViewHolder: refresh");
            if(onItemClickListener != null){
                onItemClickListener.onScrollBottom();
            }
            return;
        }
        MyViewHoler viewholder = (MyViewHoler) holder;
        viewholder.name.setText(datas.get(position).getName());
        viewholder.lable.setText(datas.get(position).getLabel());
        Glide.with(context).load(datas.get(position).getAvatar_url()).diskCacheStrategy(DiskCacheStrategy.ALL).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(viewholder.avatar);
        Glide.with(context).load(datas.get(position).getRecommend_images().get(0)).diskCacheStrategy(DiskCacheStrategy.ALL).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(viewholder.image);
        if (new DataBaseUtil().getInstance(context).isExist(datas.get(position).getId(),"designer","designerId")){
            viewholder.attention.setChecked(true);
        }

    }


    @Override
    public int getItemViewType(int position) {
        /**
         * 最后一个item返回刷新布局
         */
        if(position == getItemCount()-1){
            return 1;
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        return datas.size() + 1;
    }

    class MyViewHoler extends RecyclerView.ViewHolder{
        ImageView image, avatar;
        TextView name, lable;
        CheckBox attention;

        public MyViewHoler(final View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            avatar = (ImageView) itemView.findViewById(R.id.designer_avatar);
            name = (TextView) itemView.findViewById(R.id.designer_name);
            lable = (TextView) itemView.findViewById(R.id.designer_label);
            attention = (CheckBox) itemView.findViewById(R.id.attention);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onItemClickListener != null){
                        onItemClickListener.onItemClick(itemView,getAdapterPosition());
                    }
                }
            });
            //attention
            //// TODO: 2016/11/19 attention
            attention.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){
                        buttonView.setText("已关注");
                        if (!new DataBaseUtil().getInstance(context).isExist(datas.get(getAdapterPosition()).getId(),"designer","designerId")){
                            new DataBaseUtil().getInstance(context).saveDesigner(datas.get(getAdapterPosition()).getId()); }
                        return;
                    }
                    buttonView.setText("+关注");
                    new DataBaseUtil().getInstance(context).removeDesigner(datas.get(getAdapterPosition()).getId());
                }
            });
        }
    }

    class RefershViewholder extends RecyclerView.ViewHolder{
        public RefershViewholder(View itemView) {
            super(itemView);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
        void onScrollBottom();
    }
}
