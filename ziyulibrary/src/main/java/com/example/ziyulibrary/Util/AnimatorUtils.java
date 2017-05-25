package com.example.ziyulibrary.Util;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;

/**
 * Created by Ziyu on 2016/10/27.
 */

public class AnimatorUtils {
    /**
     * @param view                需要设置动画的view
     * @param translationY        偏移量
     * @param animatorTime        动画时间
     * @param isStartAnimator     是否开启指示器
     * @param isStartInterpolator 是否开始动画
     * @return 平移动画
     */
    public static Animator showUpAndDownBounce(View view, int translationY, int animatorTime, boolean isStartAnimator, boolean isStartInterpolator) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, "translationY", translationY);
        if (isStartInterpolator) {
            objectAnimator.setInterpolator(new OvershootInterpolator());
        }
        objectAnimator.setDuration(animatorTime);
        if (isStartAnimator) {
            objectAnimator.start();
        }
        return objectAnimator;
    }
    /**
     * 移动ScrollView的x轴
     * @param view 要移动的ScrollView
     * @param toX  要移动到的X轴坐标
     * @param time 动画持续时间
     * @param delayTime 延迟开始动画的时间
     * @param isStart 是否开始动画
     * @return
     */
    public static Animator moveScrollViewToX(View view, int toX, int time, int delayTime, boolean isStart) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(view, "scrollX", new int[]{toX});
        objectAnimator.setDuration(time);
        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator.setStartDelay(delayTime);
        if (isStart)
            objectAnimator.start();
        return objectAnimator;
    }

    public static Animator scaleTabView(View view,float start,float to){
        AnimatorSet animatorSet = new AnimatorSet();//组合动画
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", start, to);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", start, to);

        animatorSet.setDuration(300);
        animatorSet.play(scaleX).with(scaleY);//两个动画同时开始
        animatorSet.start();
        return animatorSet;
    }

    public static Animator moveScrollViewToY(View view, int fromY,int toY, int time, int delayTime, boolean isStart) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(view, "scrollY", new int[]{fromY,toY});
        objectAnimator.setDuration(time);
        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator.setStartDelay(delayTime);
        if (isStart)
            objectAnimator.start();
        return objectAnimator;
    }

    /**
     * 将View的背景颜色更改，使背景颜色转换更和谐的过渡动画
     * @param view   要改变背景颜色的View
     * @param preColor  上个颜色值
     * @param currColor 当前颜色值
     * @param duration  动画持续时间
     */
    public static void showBackgroundColorAnimation(View view, int preColor, int currColor, int duration) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(view, "backgroundColor", new int[]{preColor, currColor});
        objectAnimator.setDuration(duration);
        objectAnimator.setEvaluator(new ArgbEvaluator());
        objectAnimator.start();

    }



}