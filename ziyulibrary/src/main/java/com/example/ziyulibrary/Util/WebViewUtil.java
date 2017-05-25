package com.example.ziyulibrary.Util;

import android.webkit.WebSettings;
import android.webkit.WebView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ziyu on 2016/11/3.
 */

public class WebViewUtil {

    /**css属性参考*/
    public final static String CSS_STYLE =
            "<style>* {font-size:16px;line-height:20px;} p {color:#333;} a {color:#3E62A6;} img {max-width:310px;} pre {font-size:9pt;line-height:12pt;font-family:Courier New,Arial;border:1px solid #ddd;border-left:5px solid #6CE26C;background:#f6f6f6;padding:5px;}</style>";

    /**优化webView显示效果*/
    public void  subWebView(WebView webView, String html){
        if(html!=null) {
            //设置
            String imgStyle = "<style> p{font-size:16px;line-height:30px;} img{ max-width:100%;height:auto;} </style>";
            String reg = "style=\"([^\"]+)\"";
            Pattern pattern = Pattern.compile(reg);
            Matcher matcher = pattern.matcher(html);
            String str = matcher.replaceAll("")+imgStyle;
            String h =  str.replaceAll("<p><img","<p align=center><img");
            webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH); //极速渲染。。。
            webView.loadDataWithBaseURL(null,h,"text/html","UTF-8",null);
        }
    }
}
