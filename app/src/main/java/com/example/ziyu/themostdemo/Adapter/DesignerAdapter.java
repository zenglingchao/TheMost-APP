package com.example.ziyu.themostdemo.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.ziyu.themostdemo.Fragment.DesignerPageFragment;
import com.example.ziyu.themostdemo.Fragment.MyDesignerPageFragment;

/**
 * Created by Ziyu on 2016/10/31.
 */
public class DesignerAdapter extends FragmentStatePagerAdapter {

    private String[] urls;

    public DesignerAdapter(FragmentManager fm){
        this(fm,null);
    }

    public DesignerAdapter(FragmentManager fm, String[] URLS) {
        super(fm);
        this.urls = URLS;
    }
    @Override
    public Fragment getItem(int position) {
       if (position == 0){
            return MyDesignerPageFragment. getInstance(urls[0]);
        }
        return DesignerPageFragment.getInstance(urls[position]);
    }

    @Override
    public int getCount() {
        return urls == null ? 0 :urls.length;
    }
}
