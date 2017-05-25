package com.example.ziyu.themostdemo.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.ziyu.themostdemo.Adapter.DiscoverAdapter;
import com.example.ziyu.themostdemo.Base.BaseFragment;
import com.example.ziyu.themostdemo.Constants;
import com.example.ziyu.themostdemo.Entity.DiscoverHeadEntity;
import com.example.ziyu.themostdemo.R;
import com.example.ziyu.themostdemo.Util.RetrofitUtil;
import com.google.gson.Gson;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ScaleTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Ziyu on 2016/10/25.
 */
public class DiscoverFragment extends BaseFragment implements RetrofitUtil.DownListener {

    @Bind(R.id.viewpager)
    ViewPager mViewPager;
    @Bind(R.id.magic_indicator)
    MagicIndicator magicIndicator;

    private List<String> mDataList = new ArrayList<>();
    private DiscoverAdapter adapter;

    @Override
    public int getContentId() {
        return R.layout.fragment_discover;
    }

    @Override
    public void init(View view) {
        adapter = new DiscoverAdapter(getChildFragmentManager());
        mViewPager.setOverScrollMode(ViewPager.OVER_SCROLL_NEVER); //禁用边界效果
        mViewPager.setOffscreenPageLimit(5);
    }

    @Override
    public void loadData() {
        //下载头部
        new RetrofitUtil(getContext())
                .setDownListener(this)
                .downJson(Constants.DISCOVER_HEAD, 0x001);
    }

    private void initMagicIndicator() {
        //初始化通用指示器
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        //adapter设置指示器样式和内容
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {

            @Override
            public int getCount() {
                return mDataList == null ? 0 : mDataList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                SimplePagerTitleView simplePagerTitleView = new ScaleTransitionPagerTitleView(context);
                simplePagerTitleView.setNormalColor(Color.GRAY);
                simplePagerTitleView.setSelectedColor(Color.WHITE);
                simplePagerTitleView.setText(mDataList.get(index));
                simplePagerTitleView.setPadding(60, 0, 60, 0);
                simplePagerTitleView.setTextSize(15);
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mViewPager.setCurrentItem(index);
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setMode(LinePagerIndicator.MODE_EXACTLY);
                indicator.setColors(Color.WHITE);
                indicator.setLineWidth(40);
                indicator.setLineHeight(5);
                return indicator;
            }
        });
        //设置指示器
        magicIndicator.setNavigator(commonNavigator);
    }

    @Override
    public Object paresJson(String json, int requestCode) {
        return new Gson().fromJson(json, DiscoverHeadEntity.class);
    }


    @Override
    public void downSucc(Object object, int requestCode) {
        DiscoverHeadEntity entity = (DiscoverHeadEntity) object;
        mDataList.add(Constants.ILIKE);
        mDataList.add(Constants.MYDESIGNERS);
        mDataList.add(Constants.DAILY);
        for (int i = 0; i < entity.getData().getCategories().size(); i++) {
            mDataList.add(entity.getData().getCategories().get(i).getName());
        }
        initMagicIndicator();
        //刷新数据
        adapter.setDatas(entity.getData().getCategories());
        mViewPager.setAdapter(adapter);
        //绑定指示器和Viewpager
        ViewPagerHelper.bind(magicIndicator, mViewPager);
        //喜欢和关注为空 定位到2
       // magicIndicator.getChildAt(2).performClick();
    }
}
