package com.example.ziyu.themostdemo.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ziyu on 2016/11/8.
 */

public class BinnerPagerAdapter extends PagerAdapter {

    List<String> urlList;
    Context context;
    public BinnerPagerAdapter (Context context){
        this.context = context;
        this.urlList = new ArrayList<>();
    }
    public void setDatas(List<String> urllist){
        this.urlList = urllist;
        this.notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return urlList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView image = new ImageView(context);
        Glide.with(context)
                .load(urlList.get(position))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(image);
        container.addView(image, ViewPager.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
      return image;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
      container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
