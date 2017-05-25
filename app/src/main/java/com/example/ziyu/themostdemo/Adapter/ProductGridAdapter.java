package com.example.ziyu.themostdemo.Adapter;

import android.content.Context;

import com.example.ziyu.themostdemo.Base.AbsBaseAdapter;
import com.example.ziyu.themostdemo.Entity.ProductEntity;
import com.example.ziyu.themostdemo.R;

/**
 * Created by Ziyu on 2016/11/11.
 */

public class ProductGridAdapter extends AbsBaseAdapter<ProductEntity.DataBean.ProductsBean> {

    public ProductGridAdapter(Context context) {
        super(context, R.layout.item_product);
    }

    @Override
    public int getCount() {
        if (super.getCount() > 10) return 10;
        return super.getCount();
    }

    @Override
    public void bindView(ViewHolder viewHolder, ProductEntity.DataBean.ProductsBean data, int position) {
        viewHolder.bindImageView(R.id.image, data.getCover_images().get(0), R.mipmap.ic_mine_portrait);
    }

}