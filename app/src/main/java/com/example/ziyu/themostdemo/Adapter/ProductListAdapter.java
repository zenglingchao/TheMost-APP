package com.example.ziyu.themostdemo.Adapter;

import android.content.Context;

import com.example.ziyu.themostdemo.Base.AbsBaseAdapter;
import com.example.ziyu.themostdemo.Entity.ProductInfoEntity;
import com.example.ziyu.themostdemo.R;

/**
 * Created by Ziyu on 2016/11/8.
 */
public class ProductListAdapter extends AbsBaseAdapter<ProductInfoEntity.DataBean.ReferProductsBean> {

    public ProductListAdapter(Context context) {
        super(context, R.layout.item_product);
    }

    @Override
    public int getCount() {
        if(super.getCount()>10) return 10;
        return super.getCount();
    }

    @Override
    public void bindView(ViewHolder viewHolder, ProductInfoEntity.DataBean.ReferProductsBean data, int position) {
        viewHolder.bindImageView(R.id.image,data.getCover_images().get(0),R.mipmap.ic_mine_portrait);
    }
}
