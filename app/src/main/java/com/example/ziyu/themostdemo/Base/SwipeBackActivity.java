package com.example.ziyu.themostdemo.Base;

import android.graphics.Color;
import android.support.v4.widget.SlidingPaneLayout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.example.ziyu.themostdemo.R;

import java.lang.reflect.Field;

/**
 * Created by Ziyu on 2016/11/1.
 */

public abstract class SwipeBackActivity extends BaseActivity implements SlidingPaneLayout.PanelSlideListener {


    @Override
    public void init() {
        initSwipeBackFinish();
    }

    public void backClick(View view){
        this.finish();
        //设置Activity退出的动画
        this.overridePendingTransition(0, R.anim.slide_finish);
    }

    @Override
    protected boolean isOpenStatus() {
        return false;
    }

    /**
     * 是否支持滑动退出
     */
    protected boolean isSupportSwipeBack() {
        return true;
    }

    /**
     * 侧滑退出activity
     */
    public void initSwipeBackFinish() {
        if (isSupportSwipeBack()) {
            SlidingPaneLayout slidingPaneLayout = new SlidingPaneLayout(this);
            //通过反射改变mOverhangSize的值为0，这个mOverhangSize值为菜单到右边屏幕的最短距离，
            //默认是32dp
            try {
                //更改属性
                Field field = SlidingPaneLayout.class.getDeclaredField("mOverhangSize");
                field.setAccessible(true);
                field.set(slidingPaneLayout, 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //设置监听事件
            slidingPaneLayout.setPanelSlideListener(this);
            slidingPaneLayout.setSliderFadeColor(getResources().getColor(android.R.color.transparent));

            View leftView = new View(this);
            leftView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            //在左边添加这个视图
            slidingPaneLayout.addView(leftView, 0);
            //获取到最顶层的视图容器
            ViewGroup decor = (ViewGroup) getWindow().getDecorView();
            //获取到左边的视图
            ViewGroup decorChild = (ViewGroup) decor.getChildAt(0);
            //设置左边的视图为透明
            decorChild.setBackgroundColor(getResources().getColor(android.R.color.transparent));
            decor.removeView(decorChild);
            decor.addView(slidingPaneLayout);
            //在右边添加这个视图
            slidingPaneLayout.addView(decorChild, 1);
        }
    }

    @Override
    public void onPanelSlide(View panel, float slideOffset) {
        SlidingPaneLayout slidingPaneLayout = (SlidingPaneLayout) panel.getParent();
        slidingPaneLayout.getChildAt(0).setBackgroundColor(Color.BLACK);
        slidingPaneLayout.getChildAt(0).setAlpha((float) (1 - slideOffset / 1.1));
        if (slideOffset == 1) {
            slidingPaneLayout.getChildAt(0).setAlpha(0);
        }
        //panel.setBackgroundColor(Color.BLACK);
        Log.d("print", "onPanelSlide: " + slideOffset);
    }

    @Override
    public void onPanelOpened(View panel) {
        finish();
        //设置Activity退出的动画
        this.overridePendingTransition(0, R.anim.slide_finish);
    }

    @Override
    public void onPanelClosed(View panel) {

    }
}
