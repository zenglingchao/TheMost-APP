package com.example.ziyu.themostdemo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.ziyu.themostdemo.Entity.MagazineEntity;
import com.example.ziyu.themostdemo.R;
import com.wirelesspienetwork.overview.model.OverviewAdapter;
import com.wirelesspienetwork.overview.model.ViewHolder;

import java.util.List;

/**
 * Created by Ziyu on 2016/10/24.
 */
public class MagazineAdapter extends OverviewAdapter<ViewHolder,MagazineEntity.DataBean.ArticlesBean>{

    public MagazineAdapter(List<MagazineEntity.DataBean.ArticlesBean> articlesBeen) {
        super(articlesBeen);
    }

    @Override
    public ViewHolder onCreateViewHolder(Context context, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_magazine,null);
        return new ViewHolder<View, Object>(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder) {
        TextView title = (TextView) viewHolder.itemView.findViewById(R.id.title);
        TextView  username = (TextView) viewHolder.itemView.findViewById(R.id.username);
        TextView  subTitle = (TextView) viewHolder.itemView.findViewById(R.id.sub);
        ImageView avatar = (ImageView) viewHolder.itemView.findViewById(R.id.avatar);
        ImageView image = (ImageView) viewHolder.itemView.findViewById(R.id.image);

        MagazineEntity.DataBean.ArticlesBean bean = (MagazineEntity.DataBean.ArticlesBean) viewHolder.model;
        title.setText(bean.getTitle());
        username.setText(bean.getAuthor().getUsername());
        subTitle.setText(bean.getSub_title());
        Glide.with(avatar.getContext()).load(bean.getAuthor().getAvatar_url()).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(avatar);
        Glide.with(image.getContext()).load(bean.getImage_url()).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(image);
    }
}
