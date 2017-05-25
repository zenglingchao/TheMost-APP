package com.example.ziyulibrary.Layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * com.example.ziyu.day37_qqdemo
 * Created by ziyu on 2016/10/18 .
 */

public class ToolbarBuilder {

    private Context context;
    private LayoutInflater inflater;
    private FrameLayout contentView;     //baseView
    private View baseView;              //自定义的view
    private Toolbar toolbar;             //toolbar
    private View toolbarView;        //toolbar所在布局

    /**属性:
     *1.toolbar是否悬浮窗口之上
     * 2.toolbar的高度获取
     *
     */
    private static int[] ATTRS = {
            com.example.ziyulibrary.R.attr.windowActionBarOverlay,
            com.example.ziyulibrary.R.attr.actionBarSize
    };

    public ToolbarBuilder(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        contentView = new FrameLayout(context);
        //默认布局铺满
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        contentView.setLayoutParams(params);
    }

    public ToolbarBuilder setBaseView(int resId) {
        baseView = inflater.inflate(resId, null);
        return this;
    }

    public ToolbarBuilder setToolbar(int resId, int toolbarId) {
        toolbarView = inflater.inflate(resId, null);
        toolbar = (Toolbar) toolbarView.findViewById(toolbarId);
        return this;
    }

    /**
     * 组合布局并返回
     * @return
     */
    public View create() {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(ATTRS);
        /*获取主题中定义的悬浮标志*/
        boolean overly = typedArray.getBoolean(0,false);
        /*获取主题中定义的toolbar的高度*/
        int toolBarSize = (int) typedArray.getDimension(1, context.getResources().getDimension(com.example.ziyulibrary.R.dimen.abc_action_bar_default_height_material));
        typedArray.recycle();
        /*如果是悬浮状态,则不需要设置间距*/
        params.topMargin = overly ? 0 : toolBarSize;

        //针对DrawerLayout的处理,防止toolbar位于drawer上部
        if(baseView instanceof DrawerLayout){
            View mainView = ((DrawerLayout) baseView).getChildAt(0);
            FrameLayout mainLayout = new FrameLayout(context);
            mainLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            ((DrawerLayout) baseView).removeViewAt(0);
            mainLayout.addView(mainView,params);
            mainLayout.addView(toolbarView);
            ((DrawerLayout) baseView).addView(mainLayout,0);
            return baseView;
        }

        contentView.addView(baseView,params);
        contentView.addView(toolbarView);
        return contentView;
    }

    /**
     * 允许提供自定义布局参数
     *
     * @param params
     * @return
     */
    public ToolbarBuilder setContentParams(ViewGroup.LayoutParams params) {
        contentView.setLayoutParams(params);
        return this;
    }

    /**
     * 获取toolbar
     *
     * @return
     */
    public Toolbar getToolbar() {
        return toolbar;
    }
}
