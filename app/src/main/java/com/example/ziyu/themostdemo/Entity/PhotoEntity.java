package com.example.ziyu.themostdemo.Entity;

import android.graphics.Bitmap;

/**
 * Created by Ziyu on 2016/11/3.
 */

public class PhotoEntity {

    String url;
    Bitmap bitmap;

    @Override
    public String toString() {
        return "PhotoEntity{" +
                "url='" + url + '\'' +
                ", bitmap=" + bitmap +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public PhotoEntity(String url, Bitmap bitmap) {
        this.url = url;
        this.bitmap = bitmap;
    }
}
