package com.example.ziyu.themostdemo.Adapter;

import android.content.Context;
import android.widget.ImageView;

import com.example.ziyu.themostdemo.Base.AbsBaseAdapter;
import com.example.ziyu.themostdemo.R;

/**
 * Created by Ziyu on 2016/11/16.
 */
public class MineAdapter extends AbsBaseAdapter<String>{


    int[] icons = {R.drawable.icon_my_daily,R.drawable.ic_mine_attention_normal,R.drawable.ic_mine_wish_list_normal,R.drawable.ic_mine_feedback};

    public MineAdapter(Context context) {
        super(context, R.layout.item_mine);
    }

    @Override
    public void bindView(ViewHolder viewHolder, String data, int position) {
        viewHolder.bindTextView(R.id.title,data);
        ImageView view = (ImageView) viewHolder.getView(R.id.icon);
        view.setImageResource(icons[position]);
    }
}
