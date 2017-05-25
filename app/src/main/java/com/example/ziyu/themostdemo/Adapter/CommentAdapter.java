package com.example.ziyu.themostdemo.Adapter;

import android.content.Context;

import com.example.ziyu.themostdemo.Base.AbsBaseAdapter;
import com.example.ziyu.themostdemo.Entity.MagazineInfoEntity;
import com.example.ziyu.themostdemo.R;
import com.example.ziyu.themostdemo.Util.DateUtil;

import java.util.List;

/**
 * Created by Ziyu on 2016/11/2.
 */
public class CommentAdapter extends AbsBaseAdapter<MagazineInfoEntity.DataBean.CommentsBean> {
    public CommentAdapter(Context context) {
        super(context, R.layout.item_comment);
    }
    public CommentAdapter(Context context,int resId){
        super(context, resId);
    }

    @Override
    public void bindView(ViewHolder viewHolder, MagazineInfoEntity.DataBean.CommentsBean data, int position) {
        viewHolder.bindImageView(R.id.userAvatar,data.getAuthor().getAvatar_url(),R.mipmap.ic_mine_portrait);
        viewHolder.bindTextView(R.id.username,data.getAuthor().getUsername());
        viewHolder.bindTextView(R.id.content,data.getContent());
        viewHolder.bindTextView(R.id.createAt, DateUtil.getTime(data.getCreated_at()));
    }

    @Override
    public int getCount() {
        if(super.getCount()>10) return 10;
        return super.getCount();
    }

    @Override
    public void addDatas(List<MagazineInfoEntity.DataBean.CommentsBean> datas) {
        this.datas.addAll(0,datas);
        this.notifyDataSetChanged();
    }
}
