package com.example.ziyu.themostdemo.Adapter;

import android.content.Context;

import com.example.ziyu.themostdemo.Base.AbsBaseAdapter;
import com.example.ziyu.themostdemo.Entity.ProductInfoEntity;
import com.example.ziyu.themostdemo.R;
import com.example.ziyu.themostdemo.Util.DateUtil;

/**
 * Created by Ziyu on 2016/11/8.
 */

public class CommentListAdapter extends AbsBaseAdapter<ProductInfoEntity.DataBean.CommentsBean> {
    public CommentListAdapter(Context context) {
        super(context, R.layout.item_comment);
    }

    public CommentListAdapter(Context context, int resId) {
        super(context, resId);
    }

    @Override
    public void bindView(ViewHolder viewHolder, ProductInfoEntity.DataBean.CommentsBean data, int position) {
        viewHolder.bindImageView(R.id.userAvatar, data.getAuthor().getAvatar_url(), R.mipmap.ic_mine_portrait);
        viewHolder.bindTextView(R.id.username, data.getAuthor().getUsername());
        viewHolder.bindTextView(R.id.content, data.getContent());
        viewHolder.bindTextView(R.id.createAt, DateUtil.getTime(data.getCreated_at()));
    }

    @Override
    public int getCount() {
        if (super.getCount() > 10) return 10;
        return super.getCount();
    }
}