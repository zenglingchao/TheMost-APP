package com.example.ziyu.themostdemo.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.ziyu.themostdemo.Entity.DiscoverEntity;
import com.example.ziyu.themostdemo.R;
import com.example.ziyu.themostdemo.Weight.SmileView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ziyu on 2016/10/26.
 */
public class DiscoverListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<DiscoverEntity.DataBean.ProductsBean> datas;

    private OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public DiscoverListAdapter(Context context) {
        this.context = context;
        this.datas = new ArrayList<>();
    }

    public void addDatas(List<DiscoverEntity.DataBean.ProductsBean> datas) {
        /**
         * 添加到footer之前
         */
        this.datas.addAll(getItemCount()-1,datas);
        this.notifyDataSetChanged();
    }

    public void setDatas(List<DiscoverEntity.DataBean.ProductsBean> datas) {
        this.datas = datas;
        this.notifyDataSetChanged();
    }

    public int getProductId(int position){
        return datas.get(position).getId();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == 1){
            /**
             * 返回一个底部刷新布局
             */
            return new RefreshHolder(LayoutInflater.from(context).inflate(R.layout.item_load_footer,parent,false));
        }
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_discover, parent, false));
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        /**
         * 滑倒刷新Item时直接回调
         */
        if(getItemViewType(position) == 1){
            if(onItemClickListener != null){
                onItemClickListener.onScrollBottom();
            }
            return;
        }
        /**
         * 正常Item
         */
        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.name.setText(datas.get(position).getDesigner().getName());
        viewHolder.lable.setText(datas.get(position).getDesigner().getLabel());
        viewHolder.product.setText(datas.get(position).getName());
        Glide.with(context).load(datas.get(position).getDesigner().getAvatar_url()).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(viewHolder.avatar);
        Glide.with(context).load(datas.get(position).getCover_images().get(0)).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(viewHolder.image);
        viewHolder.smileView.setGravity(Gravity.RIGHT);
        viewHolder.smileView.setNum(datas.get(position).getLike_user_num(),datas.get(position).getUnlike_user_num());

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
        /**
         * 添加刷新页
         */
        return datas.size() + 1;
    }

    /**
     * 内容Item的Viewholder
     */
    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image, avatar;
        TextView name, lable, product;
        SmileView smileView;

        public MyViewHolder(final View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            avatar = (ImageView) itemView.findViewById(R.id.designer_avatar);
            name = (TextView) itemView.findViewById(R.id.designer_name);
            lable = (TextView) itemView.findViewById(R.id.designer_label);
            product = (TextView) itemView.findViewById(R.id.product_name);
            smileView = (SmileView) itemView.findViewById(R.id.smileView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onItemClickListener != null){
                        onItemClickListener.onItemClick(itemView,getAdapterPosition());
                    }
                }
            });
        }
    }

    /**
     * 刷新Item的Viewholder
     */
     class RefreshHolder extends RecyclerView.ViewHolder {
         ProgressBar loadImage;
        public RefreshHolder(final View itemView) {
            super(itemView);
            loadImage = (ProgressBar) itemView.findViewById(R.id.loadImage);
        }
    }


    public interface OnItemClickListener{
        void onItemClick(View view, int position);
        void onScrollBottom();
    }
}
