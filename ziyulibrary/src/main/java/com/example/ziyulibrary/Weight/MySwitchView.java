package com.example.ziyulibrary.Weight;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.ziyulibrary.R;


/**
 * Created by ziyu on 2016/9/22  20:50.
 */

public class MySwitchView extends View {

    private Bitmap bitmapFrame,//边框图片
            bitmapBottom,//底图
            bitmapUnPressed,//按钮未按中状态
            bitmapPressed,//按钮按下状态
            bitmapMask;//遮障图


    private Paint paint;
    private Bitmap showBtn;//当前显示的按钮图片
    private Rect mRect;

    private int movex;  //移动的距离
    private int moveMax; //移动到顶的最大距离

    //当前按钮的开关状态
    private boolean isChecked = false;

    private OnSwitchListener onSwitchListener; //接口回调对象

    public void setOnSwitchListener(OnSwitchListener onSwitchListener) {
        this.onSwitchListener = onSwitchListener;
    }

    public MySwitchView(Context context) {
        this(context,null);
    }

    public MySwitchView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MySwitchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init() {
        //初始化图片资源
        bitmapFrame = BitmapFactory.decodeResource(getResources(), R.drawable.checkswitch_frame);
        bitmapBottom = BitmapFactory.decodeResource(getResources(), R.drawable.checkswitch_bottom);
        bitmapUnPressed = BitmapFactory.decodeResource(getResources(), R.drawable.checkswitch_btn_unpressed);
        bitmapPressed = BitmapFactory.decodeResource(getResources(), R.drawable.checkswitch_btn_pressed);
        bitmapMask = BitmapFactory.decodeResource(getResources(), R.drawable.checkswitch_mask);
        //默认显示未按下状态
        showBtn = bitmapUnPressed;
        //初始化画笔
        paint = new Paint();
        paint.setAntiAlias(true);
        //设置最大的移动距离
        moveMax = bitmapBottom.getWidth() - bitmapFrame.getWidth();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        mRect = new Rect(movex, 0, bitmapFrame.getWidth() + movex, bitmapFrame.getHeight());
        Rect rectFrame = new Rect(0, 0, bitmapFrame.getWidth(), bitmapFrame.getHeight());

        canvas.saveLayer(new RectF(rectFrame), null, 0);//在当前画布上创建一个新图层
        //绘制底图
        canvas.drawBitmap(bitmapBottom, mRect, rectFrame, null);
        //绘制边框
        canvas.drawBitmap(bitmapFrame, rectFrame, rectFrame,null);
        //绘制按钮
        canvas.drawBitmap(showBtn, mRect, rectFrame, null);
        //为画笔设置剪切蒙版
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        //绘制遮障
        canvas.drawBitmap(bitmapMask, rectFrame, rectFrame, paint);

        canvas.restore();//把新图层的内容显示到原先的画布上
        paint.reset();
    }
    private int bx;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = 0; //判断是否是拖动状态 移动时置为-1 点击重置为0;
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x = 0;
                //将显示的按钮替换成被按下的图片
                showBtn = bitmapPressed;
                //获得按下时的x坐标
                bx = (int) event.getX();
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                x = -1;
                int ex = (int) event.getX();
                movex -= ex - bx;
                bx = ex;
                //判断范围
                if(movex < 0){
                    movex = 0;
                }
                if(movex > moveMax){
                    movex = moveMax;
                }
                break;
            case MotionEvent.ACTION_UP:

                if(movex == 0 && x == 0){
                    movex = moveMax;
                }else if(movex == moveMax && x == 0){
                    movex = 0;
                }
                //将显示的按钮替换成未被按下的图片
                showBtn = bitmapUnPressed;
                if(movex > 0 && movex < moveMax){
                    if(movex < moveMax/2){
                        movex = 0;
                    }
                    if(movex >= moveMax/2){
                        movex = moveMax;
                    }
                }
                //设置按钮的当前状态
                boolean checked = false;
                if(movex == 0){
                    checked = false;
                }
                if(movex == moveMax){
                    checked = true;
                }
                if(checked != isChecked){
                    isChecked = checked;
                    //调用回调方法
                    if(onSwitchListener != null){
                        onSwitchListener.onSwitch(this, isChecked);
                    }
                }

                invalidate();
                break;
        }
        invalidate();
        return true;
    }


    public interface OnSwitchListener{
        void onSwitch(MySwitchView switchButton, boolean ischecked);
    }
}
