package com.example.ziyulibrary.Weight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Ken on 2016/9/21.9:17
 *
 * 自定义View
 *
 * 球形自定义View
 *
 * 自定义的分类:
 *      1、组合控件
 *      2、拓展控件 -- 在原有的控件上拓展一些功能
 *      3、完全自定义控件
 *              1）完全自定义View
 *              2）完全自定义ViewGroup
 *
 * 自定义View中的三个核心方法：
 * onMeasure : 该方法用于测量控件的大小
 * onLayout : 通常用于自定义ViewGroup，用于摆放子控件的位置
 * onDraw ：绘制
 *
 */
public class BallView extends View {

    /**
     * 画笔的对象
     */
    private Paint paint;
    private int cx = 200;
    private int cy = 200;

    /**
     * 如果这个自定义View需要通过代码的方式创建，则应该重写该构造方法
     * @param context
     */
    public BallView(Context context) {
        this(context, null);
    }

    /**
     * 如果自定义View需要在布局xml文件中设置，则应该重写该构造方法
     * @param context
     * @param attrs
     */
    public BallView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * 如果自定义View需要在布局xml文件中设置,并且设置了style属性，则应该重写该构造方法
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public BallView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        //初始化画笔
        paint = new Paint();
        paint.setColor(Color.parseColor("#ff0000"));
        paint.setAntiAlias(true);//抗锯齿
    }


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(cx, cy, 50, paint);
    }


    /**
     * 触摸事件处理方法
     * @param event
     * @return 返回true表示当前控件对这个事件感兴趣，因此系统会将后续的事件再传递过来
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                //手指按下事件
//                Log.d("print", "---->手指按下");
                draw(event);
                return true;
            case MotionEvent.ACTION_MOVE:
                //手指移动事件
//                Log.d("print", "---->手指滚动");
                draw(event);
                break;
            case MotionEvent.ACTION_UP:
                //手指抬起事件
//                Log.d("print", "---->手指抬起");
                break;
        }
        return super.onTouchEvent(event);
    }

    public void draw(MotionEvent event){
        int x = (int) event.getX();
        int y = (int) event.getY();
        cx = x;
        cy = y;

        invalidate();//重绘控件 -- 当调用该方法后，会自动调用onDraw方法进行控件的重绘
//        postInvalidate();//重绘控件 -- 通常在子线程中调用
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
}
