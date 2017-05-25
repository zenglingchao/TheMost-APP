package com.example.ziyulibrary.Weight.FlipStackView;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ziyu on 2016/10/24.
 */
public class MagazinePagerAdapter extends FragmentPagerAdapter{
    private Context context;
    private List<MagazineEntity.DataBean.ArticlesBean> datas;

    public MagazinePagerAdapter(FragmentManager fm) {
        super(fm);
        this.datas = new ArrayList<>();
    }

    public void setDatas(List<MagazineEntity.DataBean.ArticlesBean> datas){
        this.datas = datas;
        this.notifyDataSetChanged();
    }


    @Override
    public Fragment getItem(int position) {
        return MagazinePagerFragment.getInstance(datas.get(position));
    }

    @Override
    public int getCount() {
        return datas.size();
    }
/*
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }*/

}
