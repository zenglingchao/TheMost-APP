package com.example.ziyulibrary.Weight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2016/10/20.
 * 自定义view
 */
public class GhostView extends View{

    // View宽高
    private int mWidth, mHeight;
    // 默认宽高(WRAP_CONTENT)
    private int mDefaultWidth,mDefaultHeight;
    // 画笔
    Paint mBodyPaint, mEyesPaint, mShadowPaint;
    // 头部的半径
    private int mHeadRadius;
    // 圆心(头部)的X坐标
    private int mHeadCentreX;
    // 圆心(头部)的Y坐标
    private int mHeadCentreY;
    // 头部最左侧的坐标
    private int mHeadLeftX;
    // 头部最右侧的坐标
    private int mHeadRightX;
    // 距离View顶部的内边距
    private int mPaddingTop;

    // 影子所占区域
    private RectF mRectShadow;
    // 小鬼身体和影子之间的举例
    private int paddingShadow;

    private Path mPath = new Path();
    // 小鬼身体胖过头部的宽度
    private int mGhostBodyWSpace;

    // 单个裙褶的宽高
    private int mSkirtWidth, mSkirtHeight;
    // 裙褶的个数
    private int mSkirtCount = 7;

    public GhostView(Context context) {
        this(context,null);
    }

    public GhostView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public GhostView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mDefaultWidth = dip2px(getContext(),120);
        mDefaultHeight = dip2px(getContext(),180);
        mPaddingTop = dip2px(getContext(),20);

        mBodyPaint = new Paint();
        mBodyPaint.setAntiAlias(true);
        mBodyPaint.setStyle(Paint.Style.FILL);
        mBodyPaint.setColor(Color.WHITE);

        mEyesPaint = new Paint();
        mEyesPaint.setAntiAlias(true);
        mEyesPaint.setStyle(Paint.Style.FILL);
        mEyesPaint.setColor(Color.BLACK);

        mShadowPaint = new Paint();
        mShadowPaint.setAntiAlias(true);
        mShadowPaint.setStyle(Paint.Style.FILL);
        mShadowPaint.setColor(Color.argb(60, 0, 0, 0));

        Log.d("print", "init: "+mDefaultWidth+"-----》"+mDefaultHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawHead(canvas);
        drawShadow(canvas);
        drawBody(canvas);
        drawEyes(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec),measureHeight(heightMeasureSpec));
    }

    private int measureWidth(int widthMeasureSpec) {
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);
        if (specMode == MeasureSpec.EXACTLY) {
            mWidth = specSize;
        } else if (specMode == MeasureSpec.AT_MOST) {
            mWidth = Math.min(mDefaultWidth, specSize);
        }
        return mWidth;
    }

    private int measureHeight(int heightMeasureSpec) {
        int specMode = MeasureSpec.getMode(heightMeasureSpec);
        int specSize = MeasureSpec.getSize(heightMeasureSpec);
        if (specMode == MeasureSpec.EXACTLY) {
            mHeight = specSize;
        } else if (specMode == MeasureSpec.AT_MOST) {
            mHeight = Math.min(mDefaultHeight, specSize);
        }
        return mHeight;
    }

    //画头部
    private void drawHead(Canvas canvas) {
        mHeadRadius = mWidth / 3;
        mHeadCentreX = mWidth / 2;
        mHeadCentreY = mWidth / 3 + mPaddingTop;
        mHeadLeftX = mHeadCentreX - mHeadRadius;
        mHeadRightX = mHeadCentreX + mHeadRadius;
        canvas.drawCircle(mHeadCentreX, mHeadCentreY, mHeadRadius, mBodyPaint);
    }

    //画影子
    private void drawShadow(Canvas canvas) {
        paddingShadow = mHeight / 10;
        mRectShadow = new RectF();
        mRectShadow.top = mHeight * 8 / 10;
        mRectShadow.bottom = mHeight * 9 / 10;
        mRectShadow.left = mWidth / 4;
        mRectShadow.right = mWidth * 3 / 4;
        canvas.drawArc(mRectShadow, 0, 360, false, mShadowPaint);
    }

    //画身体
    private void drawBody(Canvas canvas) {
        mGhostBodyWSpace = mHeadRadius * 2 / 15;
        // 先画右边的身体
        mPath.moveTo(mHeadLeftX, mHeadCentreY);
        mPath.lineTo(mHeadRightX, mHeadCentreY);
        mPath.quadTo(mHeadRightX + mGhostBodyWSpace, mRectShadow.top - paddingShadow,
                mHeadRightX - mGhostBodyWSpace, mRectShadow.top - paddingShadow);

        canvas.drawPath(mPath,mBodyPaint);

        mGhostBodyWSpace = mHeadRadius * 2 / 15;
        mSkirtWidth = (mHeadRadius * 2 - mGhostBodyWSpace * 2) / mSkirtCount;
        mSkirtHeight = mHeight / 16;


        // 从右向左画裙褶
        for (int i = 1; i <= mSkirtCount; i++) {
            if (i % 2 != 0) {
                mPath.quadTo(mHeadRightX - mGhostBodyWSpace - mSkirtWidth * i + (mSkirtWidth / 2), mRectShadow.top - paddingShadow - mSkirtHeight,
                        mHeadRightX - mGhostBodyWSpace - (mSkirtWidth * i), mRectShadow.top - paddingShadow);
            } else {
                mPath.quadTo(mHeadRightX - mGhostBodyWSpace - mSkirtWidth * i + (mSkirtWidth / 2), mRectShadow.top - paddingShadow + mSkirtHeight,
                        mHeadRightX - mGhostBodyWSpace - (mSkirtWidth * i), mRectShadow.top - paddingShadow);
            }
        }

        mPath.quadTo(mHeadLeftX - mGhostBodyWSpace, mRectShadow.top - paddingShadow, mHeadLeftX, mHeadCentreY);

        canvas.drawPath(mPath,mBodyPaint);
    }

    //画眼睛
    private void drawEyes(Canvas canvas) {
        canvas.drawCircle(mHeadCentreX , mHeadCentreY, mHeadRadius / 6, mEyesPaint);
        canvas.drawCircle(mHeadCentreX + mHeadRadius / 2, mHeadCentreY, mHeadRadius / 6, mEyesPaint);
    }


    //dp转px
    public static int dip2px(Context context, float dipValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dipValue * scale + 0.5f);
    }

    //px转dp
    public static int px2dip(Context context, float pxValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(pxValue / scale + 0.5f);
    }
}
