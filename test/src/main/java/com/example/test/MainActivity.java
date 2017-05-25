package com.example.test;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView ,image2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.image);
       // imageView.setBackgroundResource(R.drawable.animation_like);
       // image2.setBackgroundResource(R.drawable.animation_like);
        /*AnimationDrawable anim = (AnimationDrawable) imageView.getBackground();
        anim.start();*/
    }

    public void btnClick(View view){
      ///  imageView.setBackgroundResource(R.drawable.animation_dislike);
        AnimationDrawable anim = (AnimationDrawable) imageView.getBackground();
        anim.start();
    }
}
