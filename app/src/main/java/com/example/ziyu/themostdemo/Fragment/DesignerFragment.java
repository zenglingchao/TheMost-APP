package com.example.ziyu.themostdemo.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.ziyu.themostdemo.Adapter.DesignerAdapter;
import com.example.ziyu.themostdemo.Base.BaseFragment;
import com.example.ziyu.themostdemo.Constants;
import com.example.ziyu.themostdemo.R;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ScaleTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import butterknife.Bind;

/**
 * Created by Ziyu on 2016/10/30.
 */

public class DesignerFragment extends BaseFragment {

    @Bind(R.id.viewpager)
    ViewPager mViewPager;
    @Bind(R.id.magic_indicator)
    MagicIndicator magicIndicator;

    private DesignerAdapter adapter;
    /**
     * designer Tab
     */
    String[] CHANNELS = new String[]{"我关注的","推荐", "最受欢迎", "独立设计师", "大牌设计师"};
    String[] URLS = new String[]{Constants.DESIGNER,Constants.DESIGNER_RECOMEND, Constants.DESIGNER_MOSTFAVOR, Constants.DESIGNER_INDEPENDENT,Constants.DESIGNER_FAMOUS};

    @Override
    public int getContentId() {
        return R.layout.fragment_designer;
    }

    @Override
    public void init(View view) {
        adapter = new DesignerAdapter(getChildFragmentManager(),URLS);
        mViewPager.setAdapter(adapter);
        mViewPager.setOverScrollMode(ViewPager.OVER_SCROLL_NEVER); //禁用边界效果
        mViewPager.setOffscreenPageLimit(5);

        initMagicIndicator();
        //绑定指示器和Viewpager
        ViewPagerHelper.bind(magicIndicator, mViewPager);
    }

    private void initMagicIndicator() {
        //初始化通用指示器
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        //adapter设置指示器样式和内容
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {

            @Override
            public int getCount() {
                return CHANNELS == null ? 0 : CHANNELS.length;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                SimplePagerTitleView simplePagerTitleView = new ScaleTransitionPagerTitleView(context);
                simplePagerTitleView.setNormalColor(Color.GRAY);
                simplePagerTitleView.setSelectedColor(Color.WHITE);
                simplePagerTitleView.setText(CHANNELS[index]);
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
}
