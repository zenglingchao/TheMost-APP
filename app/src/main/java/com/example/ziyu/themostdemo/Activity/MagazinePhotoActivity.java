package com.example.ziyu.themostdemo.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.ziyu.themostdemo.Base.BaseActivity;
import com.example.ziyu.themostdemo.R;
import com.example.ziyu.themostdemo.Weight.HackyViewPager;
import com.example.ziyu.themostdemo.Weight.ScaleCircleNavigator;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import uk.co.senab.photoview.PhotoView;

/**
 * Created by Ziyu on 2016/11/3. 
 */

public class MagazinePhotoActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    @Bind(R.id.hviewPager)
    HackyViewPager viewPager;
    @Bind(R.id.magic_indicator1)
    MagicIndicator magicIndicator;

    private PhotoPagerAdapter adapter = new PhotoPagerAdapter();;
    private int anInt;

    @Override
    public int getContentId() {
        return R.layout.activity_magazine_photo;
    }

    @Override
    public View getContentView() {
        return null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEvent(List<String> datas){

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        anInt = 0;
        for (int i = 0; i < datas.size(); i++) {
            if(url.equals(datas.get(i))){
                anInt = i;
            }
        }
        adapter.setDatas(datas);
        viewPager.post(new Runnable() {
            @Override
            public void run() {
                viewPager.setCurrentItem(anInt);
            }
        });
    }

    @Override
    public void init() {
        viewPager.setAdapter(adapter);
        viewPager.setOverScrollMode(ViewPager.OVER_SCROLL_NEVER);
        viewPager.addOnPageChangeListener(this);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLACK));
        initMagicIndicator();
    }

    private void initMagicIndicator() {
        MagicIndicator magicIndicator = (MagicIndicator) findViewById(R.id.magic_indicator1);
        ScaleCircleNavigator scaleCircleNavigator = new ScaleCircleNavigator(this);
        scaleCircleNavigator.setCircleCount(adapter.getCount());
        scaleCircleNavigator.setNormalCircleColor(Color.DKGRAY);
        scaleCircleNavigator.setSelectedCircleColor(Color.WHITE);
        scaleCircleNavigator.setCircleClickListener(new ScaleCircleNavigator.OnCircleClickListener() {
            @Override
            public void onClick(int index) {
                viewPager.setCurrentItem(index);
            }
        });
        magicIndicator.setNavigator(scaleCircleNavigator);
        ViewPagerHelper.bind(magicIndicator, viewPager);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    static class PhotoPagerAdapter extends PagerAdapter {

        private List<String> photoViews;

        public PhotoPagerAdapter() {
            this.photoViews = new ArrayList<>();
        }

        public void setDatas(List<String> datas){
            this.photoViews = datas;
            this.notifyDataSetChanged();
        }
        @Override
        public int getCount() {
            return photoViews.size();
        }

        public View instantiateItem(ViewGroup container, int position) {
            PhotoView photoView = new PhotoView(container.getContext());
            Glide.with(container.getContext()).load(photoViews.get(position)).diskCacheStrategy(DiskCacheStrategy.ALL).into(photoView);
            container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            return photoView;
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
}
