package com.example.ziyu.themostdemo.Util;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.OvershootInterpolator;

/**
 * Created by Ziyu on 2016/10/30.
 */

public class AnimationUtil {

    public static void LoadRouteAnimaion(View view){
        AnimatorSet set = new AnimatorSet() ;
        ObjectAnimator anim = ObjectAnimator .ofFloat(view, "rotationX", 0f, 180f);
        anim.setDuration(800);
        anim.setRepeatCount(2);
        ObjectAnimator anim2 = ObjectAnimator .ofFloat(view, "rotationX", 180f, 0f);
        anim2.setDuration(800);
        anim.setRepeatCount(2);
        ObjectAnimator anim3 = ObjectAnimator .ofFloat(view, "rotationY", 0f, 180f);
        anim3.setDuration(800);
        anim.setRepeatCount(2);
        ObjectAnimator anim4 = ObjectAnimator .ofFloat(view, "rotationY", 180f, 0f);
        anim4.setDuration(800);
        anim.setRepeatCount(2);
        set.play(anim).before(anim2); //先执行anim动画之后在执行anim2
        set.play(anim3).before(anim4) ;
        set.start();
    }

    public static void LoadScaleAnimation(View view){
    }


    /**
     * @param view                需要设置动画的view
     * @param translationY        偏移量
     * @param animatorTime        动画时间
     * @param isStartAnimator    是否开始动画
     * @param isStartInterpolator 是否开启指示器
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
}
