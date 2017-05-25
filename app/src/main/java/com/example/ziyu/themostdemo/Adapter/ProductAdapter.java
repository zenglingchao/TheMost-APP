package com.example.ziyu.themostdemo.Adapter;

import android.content.Context;

import com.example.ziyu.themostdemo.Base.AbsBaseAdapter;
import com.example.ziyu.themostdemo.Entity.MagazineInfoEntity;
import com.example.ziyu.themostdemo.R;

/**
 * Created by Ziyu on 2016/11/2.
 */
public class ProductAdapter extends AbsBaseAdapter<MagazineInfoEntity.DataBean.ReferProductsBean> {

    public ProductAdapter(Context context) {
        super(context, R.layout.item_product);
    }

    @Override
    public void bindView(ViewHolder viewHolder, MagazineInfoEntity.DataBean.ReferProductsBean data, int position) {
        viewHolder.bindImageView(R.id.image,data.getCover_images().get(0),R.mipmap.ic_mine_portrait);
    }

    @Override
    public int getCount() {
        if(super.getCount()>10) return 10;
        return super.getCount();
    }
}
