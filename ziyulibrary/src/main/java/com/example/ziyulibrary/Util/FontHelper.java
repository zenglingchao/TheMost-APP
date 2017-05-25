package com.example.ziyulibrary.Util;

import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 *递归遍历子控件设置字体
 * com.example.ziyulibrary.Util
 * Created by ziyu on 2016/10/9 .
 */

public class FontHelper {
    public static final String FONTS_DIR = "fonts/";
    public static final String DEF_FONT = FONTS_DIR + "fontawesome-webfont.ttf";

    public static final void injectFont(View rootView){
        injectFont(rootView ,
                Typeface.createFromAsset(rootView.getContext().getAssets(),DEF_FONT));
    }

    public static final void injectFont(View rootView ,Typeface tf ){
        if(rootView instanceof ViewGroup){
            ViewGroup group = (ViewGroup)rootView;
            int count = group.getChildCount();
            for(int  i = 0; i<count;i++){
                injectFont(group.getChildAt(i),tf);
            }
        }else if(rootView instanceof TextView) {
            ((TextView) rootView).setTypeface(tf);
        }
    }

}
