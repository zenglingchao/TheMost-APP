package com.example.test;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Ziyu on 2016/10/26.
 */

public class SmileView extends LinearLayout implements Animator.AnimatorListener {


    public void setDefalutGravity(int defalutGravity) {
        this.defalutGravity = defalutGravity;
    }

    public void setDefalutDis(String defalutDis) {
        this.defalutDis = defalutDis;
    }

    public void setDefaultLike(String defaultLike) {
        this.defaultLike = defaultLike;
    }

    public void setDefalutSize(int defalutSize) {
        this.defalutSize = defalutSize;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public void setDisLike(int disLike) {
        this.disLike = disLike;
    }

    private String defaultLike = "喜欢";
    private String defalutDis = "无感";
    private int defalutTextColor = Color.WHITE;
    private String defaluteShadow = "#7F484848";
    private int defalutGravity = Gravity.CENTER_HORIZONTAL;
    private int defalutSize = dip2px(getContext(), 40);

    private int like = 10 ;
    private int disLike = 20; //点赞数,差评数
    private float fLike ,fDis;
    private ImageView imageLike;
    private ImageView imageDis;

    private TextView likeNum,disNum,likeText,disText;
    private LinearLayout likeBack, disBack,likeAll,disAll;
    private AnimationDrawable animLike, animDis; //笑脸帧动画
    private ValueAnimator animatorBack; //背景拉伸动画

    private int type = 0; //选择执行帧动画的笑脸 //0 笑脸 1 哭脸
    private boolean isClose = false; //判断收起动画

    public SmileView(Context context) {
        this(context, null);
    }

    public SmileView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SmileView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        bindListener();
    }

    private void init() {
        //初始化总布局
        setOrientation(HORIZONTAL);
        setGravity(defalutGravity|Gravity.BOTTOM);
        setBackgroundColor(Color.TRANSPARENT); //开始透明

        //初始化图片
        imageLike = new ImageView(getContext());
        imageDis = new ImageView(getContext());
        //添加动画资源
        imageLike.setBackgroundResource(R.drawable.animation_like);
        imageDis.setBackgroundResource(R.drawable.animation_dislike);
        //获得帧动画
        animLike = (AnimationDrawable) imageLike.getBackground();
        animDis = (AnimationDrawable) imageDis.getBackground();

        //设置百分比
        float count = like + disLike;
        fLike = like/count;
        fDis =  disLike/count;
        like = (int) (fLike*100);
        disLike = (int) (fDis*100);

        //初始化文字
        likeNum = new TextView(getContext());
        likeNum.setText(like + "%");
        likeNum.setTextColor(defalutTextColor);
        TextPaint likeNumPaint = likeNum.getPaint();
        likeNumPaint.setFakeBoldText(true); //设置字体加粗
        likeNum.setTextSize(20f);

        disNum = new TextView(getContext());
        disNum.setText(disLike + "%");
        disNum.setTextColor(defalutTextColor);
        TextPaint disNumPaint = disNum.getPaint();
        disNumPaint.setFakeBoldText(true);
        disNum.setTextSize(20f);


        likeText = new TextView(getContext());
        likeText.setText(defaultLike);
        likeText.setTextColor(defalutTextColor);

        disText = new TextView(getContext());
        disText.setText(defalutDis);
        disText.setTextColor(defalutTextColor);


        //初始化间接布局
        likeBack = new LinearLayout(getContext());
        disBack = new LinearLayout(getContext());
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(defalutSize, defalutSize);
        likeBack.addView(imageLike, params2);
        disBack.addView(imageDis, params2);
        disBack.setBackgroundResource(R.drawable.white_background);
        likeBack.setBackgroundResource(R.drawable.white_background);

        //单列总布局
        likeAll = new LinearLayout(getContext());
        disAll = new LinearLayout(getContext());
        likeAll.setOrientation(VERTICAL);
        disAll.setOrientation(VERTICAL);
        likeAll.setGravity(Gravity.CENTER_HORIZONTAL);
        disAll.setGravity(Gravity.CENTER_HORIZONTAL);
        likeAll.setBackgroundColor(Color.TRANSPARENT);
        disAll.setBackgroundColor(Color.TRANSPARENT);

        //添加文字图片进单列
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(0,10, 0, 0);
        params.gravity = Gravity.CENTER;
        disAll.setGravity(Gravity.CENTER_HORIZONTAL);
        likeAll.setGravity(Gravity.RIGHT);
        disAll.addView(disNum,params);
        disAll.addView(disText,params);
        disAll.addView(disBack,params);

        likeAll.addView(likeNum,params);
        likeAll.addView(likeText,params);
        likeAll.addView(likeBack,params);

        LayoutParams params3 = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params3.setMargins(20, 20, 20, 20);
        params3.gravity = Gravity.BOTTOM;
        addView(disAll, params3);
        addView(likeAll, params3);
    }

    //绑定监听
    private void bindListener() {
        imageDis.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                type = 1; //设置动画对象
                animBack(); //拉伸背景
                //切换背景色
                setBackgroundColor(Color.parseColor(defaluteShadow));
                likeBack.setBackgroundResource(R.drawable.white_background);
                disBack.setBackgroundResource(R.drawable.yellow_background);
                //重置帧动画 并获得
                imageLike.setBackground(null);
                imageLike.setBackgroundResource(R.drawable.animation_like);
                animLike = (AnimationDrawable) imageLike.getBackground();

            }
        });
        imageLike.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                type = 0;
                animBack();
                setBackgroundColor(Color.parseColor(defaluteShadow));
                disBack.setBackgroundResource(R.drawable.white_background);
                likeBack.setBackgroundResource(R.drawable.yellow_background);
                imageDis.setBackground(null);
                imageDis.setBackgroundResource(R.drawable.animation_dislike);
                animDis = (AnimationDrawable) imageDis.getBackground();
            }
        });
    }

    //背景伸展动画
    public void animBack() {

        //动画执行中不能点击
        imageDis.setClickable(false);
        imageLike.setClickable(false);

        //
        final int max = Math.max(like*3,disLike*3);
        animatorBack = ValueAnimator.ofInt(5,max);
        animatorBack.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
               int magrin = (int) animation.getAnimatedValue();
               LinearLayout.LayoutParams paramsLike
                        = (LinearLayout.LayoutParams) imageLike.getLayoutParams();
                paramsLike.bottomMargin = magrin;

                if(magrin <= like*3){
                    imageLike.setLayoutParams(paramsLike);
                }
                if(magrin <= disLike*3){
                    imageDis.setLayoutParams(paramsLike);
                }
            }
        });
        isClose = false;
        animatorBack.addListener(this);
        animatorBack.setDuration(800);
        animatorBack.start();

    }

    //背景收回动画
    public void setBackUp() {
        final int max = Math.max(like*3,disLike*3);
        animatorBack = ValueAnimator.ofInt(max,5);
        animatorBack.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int magrin = (int) animation.getAnimatedValue();
                LinearLayout.LayoutParams paramsLike
                        = (LinearLayout.LayoutParams) imageLike.getLayoutParams();
                paramsLike.bottomMargin = magrin;

                if(magrin <= like*3){
                    imageLike.setLayoutParams(paramsLike);
                }
                if(magrin <= disLike*3){
                    imageDis.setLayoutParams(paramsLike);
                }
            }
        });

        animatorBack.addListener(this);
        animatorBack.setDuration(800);
        animatorBack.start();
    }

    @Override
    public void onAnimationEnd(Animator animation) {
        //重置帧动画
        animDis.stop();
        animLike.stop();

        //关闭时不执行帧动画
        if(isClose){
            //收回后可点击
            imageDis.setClickable(true);
            imageLike.setClickable(true);
            setBackgroundColor(Color.TRANSPARENT);
            return;
        }
        isClose = true;

        if (type == 0){
            animLike.start();
            objectY(imageLike);
        }else {
            animDis.start();
            objectX(imageDis);
        }
    }

    public void objectY(View view){

        //属性动画
        ObjectAnimator animator = ObjectAnimator.ofFloat(view,"translationY", -10.0f,0.0f, 10.0f, 0.0f,-10.0f,0.0f,10.0f,0);
        animator.setRepeatMode(ObjectAnimator.RESTART);
        //animator.setRepeatCount(1);
        animator.setDuration(1500);
        animator.start();

        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                setBackUp(); //执行回弹动画
            }
        });
    }

    public void objectX(View view){
        //属性动画
        ObjectAnimator animator = ObjectAnimator.ofFloat(view,"translationX", -10.0f,0.0f, 10.0f, 0.0f,-10.0f,0.0f,10.0f,0);
        animator.setRepeatMode(ObjectAnimator.RESTART);
       // animator.setRepeatCount(1);
        animator.setDuration(1500);
        animator.start();

        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                setBackUp(); //执行回弹动画
            }
        });
    }
    @Override
    public void onAnimationStart(Animator animation) {
    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }

    //dp转px
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    //px转dp
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

}
