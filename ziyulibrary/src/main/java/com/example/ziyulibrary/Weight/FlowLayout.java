package com.example.ziyulibrary.Weight;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * 流式布局 自动换行
 * Created by ziyu on 2016/9/23  11:46.
 */

public class FlowLayout extends ViewGroup {

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     * 指定该布局的布局参数
     * 不重写则默认为 viewgroup.layoutparams
     * @param attrs
     * @return
     */
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(),attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // 测量子控件的宽高
        measureChildren(widthMeasureSpec,heightMeasureSpec);

        int wsize = MeasureSpec.getSize(widthMeasureSpec);
        int wmode = MeasureSpec.getMode(widthMeasureSpec);
        int hsize = MeasureSpec.getSize(heightMeasureSpec);
        int hmode = MeasureSpec.getMode(heightMeasureSpec);

        int allwidth = 0;   //总宽度
        int allheight = 0;  //总高度
        int linewidth = 0;  //行宽
        int lineheight = 0; //行高

        //循环遍历每个子控件
        for (int i = 0; i <getChildCount() ; i++) {
            View view = getChildAt(i); //获得子控件
            //获得子控件的布局参数
            MarginLayoutParams marginParams = (MarginLayoutParams) view.getLayoutParams();
            //当前控件的宽度和高度
            int width = view.getMeasuredWidth() + marginParams.leftMargin + marginParams.rightMargin;
            int height = view .getMeasuredHeight() + marginParams.topMargin + marginParams.bottomMargin;

            //判断是否需要换行
            if(linewidth + width <= wsize){
                linewidth += width; //累加行宽
                lineheight = Math.max(lineheight,height); //行高取最大值
            }else{
                allwidth = Math.max(allwidth,linewidth); //控件总宽取最大值
                allheight += lineheight;  //控件总高累加
                //换行重置宽高 ,添加控件
                linewidth = width;
                lineheight = height;
            }
            //当遍历到最后一个控件时, 将最后一行宽高纳入总宽高
            if(i == getChildCount()-1){
                allwidth = Math.max(allwidth,linewidth);
                allheight += lineheight;
            }
        }
        Log.d("print", "onMeasure: " + allwidth + "   " + allheight);
        setMeasuredDimension(
                wmode == MeasureSpec.EXACTLY ? wsize : allwidth ,
                hmode == MeasureSpec.EXACTLY ? hsize : allheight
        );
   }

    /**
     * 控制子控件位置摆放
     * @param changed
     * @param l
     * @param t
     * @param r
     * @param b
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
            int lineheight = 0;  //行高
            int linewidth = 0;    //行宽
            int allheight = 0;      //总高

        for (int i = 0; i <getChildCount() ; i++) {
            View view = getChildAt(i);  //获得子控件及其布局参数
            MarginLayoutParams marginlayout = (MarginLayoutParams) view.getLayoutParams();
            //测量子控件宽高
            int width = view.getMeasuredWidth();
            int height = view.getMeasuredHeight();
            //判断是否需要换行 (当前行宽 加上 子控件及其margin 宽度 大于 屏幕宽度)
            if(linewidth + width + marginlayout.leftMargin + marginlayout.rightMargin > getWidth()){
                allheight += lineheight; //叠加总高
                lineheight = 0; //重置行
                linewidth = 0;
            }
            //确认控件位置
            l = linewidth + marginlayout.leftMargin;
            t = allheight + marginlayout.topMargin;
            r = linewidth + marginlayout.leftMargin + width;
            b = allheight + marginlayout.topMargin + height;
            //将控件宽高添加到行数据中
            linewidth += width + marginlayout.rightMargin + marginlayout.leftMargin;
            lineheight = Math.max(lineheight,height + marginlayout.topMargin + marginlayout.bottomMargin);

            //摆放当前控件
            view.layout(l,t,r,b);
        }

    }
}
