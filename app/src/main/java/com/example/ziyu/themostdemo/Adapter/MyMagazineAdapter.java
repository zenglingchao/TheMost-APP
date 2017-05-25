package com.example.ziyu.themostdemo.Adapter;

import android.content.Context;

import com.example.ziyu.themostdemo.Base.AbsBaseAdapter;
import com.example.ziyu.themostdemo.Entity.MagazineInfoEntity;
import com.example.ziyu.themostdemo.R;

/**
 * Created by Ziyu on 2016/11/18.
 */
public class MyMagazineAdapter extends AbsBaseAdapter<MagazineInfoEntity>{
    public MyMagazineAdapter(Context context) {
        super(context, R.layout.item_my_magazine);
    }
    @Override
    public void bindView(ViewHolder viewHolder, MagazineInfoEntity data, int position) {

        viewHolder.bindTextView(R.id.title,data.getData().getTitle());
        viewHolder.bindTextView(R.id.sub,data.getData().getSub_title());
        viewHolder.bindImageView(R.id.image,data.getData().getImage_url(),R.drawable.ic_contact_picture);
    }
}
