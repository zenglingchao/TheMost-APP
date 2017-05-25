package com.example.ziyulibrary.Layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.ziyulibrary.R;

/**
 * Created by ziyu on 2016/8/23.
 */

public class ToolbarHelper {


    private Context context;             //上下文

    private FrameLayout contentView;     //baseView

    private View userView;              //自定义的view

    private Toolbar toolbar;             //toolbar

    private LayoutInflater inflater;    //视图构造器

    /**属性:
     *1.toolbar是否悬浮窗口之上
     * 2.toolbar的高度获取
     *
     */
    private static int[] ATTRS = {
           R.attr.windowActionBarOverlay,
            R.attr.actionBarSize
    };

    /**
     * 构造方法
     */
    public ToolbarHelper(Context context,int contentLayout){
        this.context = context;
        this.inflater = LayoutInflater.from(this.context);

        /*初始化整个布局 */
        initContentView();
        /*初始化toolbar*/
      //  initToolbar(toolbarLayout);
        /*初始化用户定义布局*/
        initUserView(contentLayout);
   }
    public ToolbarHelper creat(){
        return this;
    }

    private boolean initContentView() {
        /* 创建一个帧布局,作为视图的父容器*/
        contentView = new FrameLayout(context);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        contentView.setLayoutParams(params);
        return true;
    }

    private boolean initToolbar(int toolbarId){
        /* 通过inflater 获取 toolbar的布局文件 */
        View toolbarView = inflater.inflate(toolbarId,contentView);
        toolbar = (Toolbar) toolbarView.findViewById(R.id.toolbar);
        return true;
    }

    private boolean initUserView(int layoutId) {
        userView = inflater.inflate(layoutId,null);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(ATTRS);
        /*获取主题中定义的悬浮标志*/
        boolean overly = typedArray.getBoolean(0,false);
        /*获取主题中定义的toolbar的高度*/
        int toolBarSize = (int) typedArray.getDimension(1, context.getResources().getDimension(R.dimen.abc_action_bar_default_height_material));
        typedArray.recycle();
        /*如果是悬浮状态,则不需要设置间距*/
        params.topMargin = overly ? 0 : toolBarSize;
        contentView.addView(userView,params);
        return true;
    }

    public FrameLayout getContentView(){
          return contentView;
    }

    public Toolbar getToolbar(){
        return toolbar;
    }

}
