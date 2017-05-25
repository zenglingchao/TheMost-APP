package com.example.ziyu.themostdemo.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.ziyu.themostdemo.Constants;
import com.example.ziyu.themostdemo.Entity.DiscoverHeadEntity;
import com.example.ziyu.themostdemo.Fragment.DiscoverPageFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ziyu on 2016/10/26.
 */

public class DiscoverAdapter extends FragmentStatePagerAdapter {

    private List<DiscoverHeadEntity.DataBean.CategoriesBean> datas;

    public DiscoverAdapter(FragmentManager fm) {
        super(fm);
        datas = new ArrayList<>();
    }

    public void setDatas(List<DiscoverHeadEntity.DataBean.CategoriesBean> datas){
        this.datas = datas;
        this.notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
      if(position == 0){
            return DiscoverPageFragment.getInstance(-1, Constants.DISCOVER_DAILY); //我喜欢的
        }
        if(position == 1){
            return DiscoverPageFragment.getInstance(-1, Constants.DISCOVER_DAILY); //设计师动态
        }
        if(position == 2){
            return DiscoverPageFragment.getInstance(-1, Constants.DISCOVER_DAILY);//今日
        }
        return DiscoverPageFragment.getInstance(datas.get(position-3).getId(), Constants.DISCOVER_CONTENT); //分类
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size() + 3;
    }
}
