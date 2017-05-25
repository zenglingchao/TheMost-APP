package com.example.ziyulibrary.Material;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

/**
 * com.example.ziyulibrary.Material
 * Created by ziyu on 2016/10/8 .
 */

public class FABBBehaviorTest extends FloatingActionButton.Behavior{

    private int state = -1;
    public FABBBehaviorTest(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //绑定要响应的控件   (layout_anchor指向的)
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        return dependency instanceof ViewPager;
    }

    //----------!!该方法会持续调用 和通常Change监听调用一次不同
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        ViewPager pager = (ViewPager) dependency;
        if(pager.getCurrentItem() != 1 ){ //只在第二页显示
            child.hide();
            state = -1;  //重置为可显示状态 切回可直接显示
        }else if(pager.getCurrentItem() == 1 && state < 0){
            child.show();
        }
        return true;
    }

    @Override
    public boolean onStartNestedScroll(final CoordinatorLayout coordinatorLayout, final FloatingActionButton child,
                                       final View directTargetChild, final View target, final int nestedScrollAxes) {
        //返回boolean 判断是否响应滚动事件
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL   //目测为垂直滚动状态?
                || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
                    //super默认返回false 不响应
    }


    @Override
    public void onNestedScroll(final CoordinatorLayout coordinatorLayout, final FloatingActionButton child,
                               final View target, final int dxConsumed, final int dyConsumed,
                               final int dxUnconsumed, final int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        state = dyConsumed; //缓存滚动状态
        if (dyConsumed > 0 && child.getVisibility() == View.VISIBLE) {
            child.hide(); //>0向下 隐藏fab
        } else if (dyConsumed < 0  && child.getVisibility() != View.VISIBLE) {
            child.show(); //<0向上 显示fab
        }
    }
}
