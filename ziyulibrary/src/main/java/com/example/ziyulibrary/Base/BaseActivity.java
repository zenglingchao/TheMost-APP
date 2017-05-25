package com.example.ziyulibrary.Base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.example.ziyulibrary.R;
import com.example.ziyulibrary.Util.ScreenUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;

/**
 * Created by ziyu on 2016/9/26  12:37.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    //当前正在展示的Fragment
    private BaseFragment showFragment;
    //沉浸式状态栏
    boolean defaultStatues = false;
    //隐藏软键盘
    boolean isHide = true;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除EventBus
        EventBus.getDefault().unregister(this);
    }

    //事件接收器
    @Subscribe
    protected void eventReciver(Object object){
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getContentView() == null){
            setContentView(getContentId());
        }else{
            setContentView(getContentView());
        }
        //默认不弹出软键盘
        if(isHide){
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        }
        //注册activity
        ButterKnife.bind(this);
        //注册EventBus
        EventBus.getDefault().register(this);
        //获得FragmentManager对象
        fragmentManager = getSupportFragmentManager();
        /**
         * 沉浸式状态栏
         */
        if(isOpenStatus()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }

            //获得状态栏的高度
            int height = ScreenUtil.getStatusHeight(this);
            if(height != -1){
                //设置Padding
                View view = findViewById(R.id.actionbar);
                if(view != null){
                    view.setPadding(0, height, 0, 0);
                }
            }
        }
        init();
        bindListener();
        loadData();
    }
    /**
     * 展示Fragment
     */
    protected void showFragment(int resid, BaseFragment fragment){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //隐藏正在暂时的Fragment
        if(showFragment != null){
            fragmentTransaction.hide(showFragment);
        }

        //展示需要显示的Fragment对象
        Fragment mFragment = fragmentManager.findFragmentByTag(fragment.getClass().getName());
        if(mFragment != null){
            fragmentTransaction.show(mFragment);
            showFragment = (BaseFragment) mFragment;
        } else {
            fragmentTransaction.add(resid, fragment, fragment.getClass().getName());
            showFragment = fragment;
        }

        fragmentTransaction.commit();
    }

    Toast mToast;
    protected final static String NULL = "";
    public static final String TAG = "ziyu :";
    /**只打印Log*/
    public void log(Object msg){
      //  if(BuildConfig.DEBUG){}
            Log.i(TAG, msg.toString());
    }
    /**同时打印Logd的Toast*/
    public void toast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        Log.d(TAG, msg);
    }
    /**只显示Toast(String)*/
    public void showToast(String text) {
        if (!TextUtils.isEmpty(text)) {
            if (mToast == null) {
                mToast = Toast.makeText(getApplicationContext(), text,
                        Toast.LENGTH_SHORT);
            } else {
                mToast.setText(text);
            }
            mToast.show();
        }
    }
    /**只显示Toast(Res)*/
    public void showToast(int resId) {
        if (mToast == null) {
            mToast = Toast.makeText(getApplicationContext(), resId,
                    Toast.LENGTH_SHORT);
        } else {
            mToast.setText(resId);
        }
        mToast.show();
    }
    /**在UIThread中执行的 Toast*/
    public void toast(final Object obj) {
        try {
            runOnMain(new Runnable() {
                @Override
                public void run() {
                    if (mToast == null)
                        mToast = Toast.makeText(BaseActivity.this, NULL,Toast.LENGTH_SHORT);
                    mToast.setText(obj.toString());
                    mToast.show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public <T> T findId(int id){
        return (T)findViewById(id);
    }

    /**设置显示布局id*/
    public abstract int getContentId();
    /**设置显示布局View*/
    public abstract View getContentView();
    /**初始化控件*/
    public void init() {}
    /**加载数据*/
    public void loadData() {}
    /**绑定监听*/
    public void bindListener() {}

    /** 以动画的方式启动activity*/
    public void startActivityForAnimation(Intent intent, int animinid, int animoutid){
        startActivity(intent);
        overridePendingTransition(animinid, animoutid);
    }

    /**启动Activity 可以携带Bundle ,选择是否Finish*/
    public void startActivity(Class<? extends Activity> target, Bundle bundle, boolean finish) {
        Intent intent = new Intent();
        intent.setClass(this, target);
        if (bundle != null)
            intent.putExtra(getPackageName(), bundle);
        startActivity(intent);
        if (finish)
            finish();
    }

    /**获取上面方法携带的Bundle bundle名为包名*/
    public Bundle getBundle() {
        if (getIntent() != null && getIntent().hasExtra(getPackageName()))
            return getIntent().getBundleExtra(getPackageName());
        else
            return null;
    }

    /**执行在主线程中*/
    protected void runOnMain(Runnable runnable) {
        runOnUiThread(runnable);
    }

    /**是否打开沉浸式状态栏*/
    protected boolean isOpenStatus(){
        return defaultStatues;
    }

    /**键盘显示则隐藏，没有显示则弹出*/
    public void hideInput(){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);

    }
    /**隐藏软键盘*/
    public void hideSoftInputView() {
        InputMethodManager imm = ((InputMethodManager) this.getSystemService(Activity.INPUT_METHOD_SERVICE));
        imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);

       /* if (getWindow().getAttributes().softInputMode != WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
           // if (getCurrentFocus() != null)
                manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
       }*/
    }

    public boolean getSoftInputState(){
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        boolean isOpen=imm.isActive();//isOpen若返回true，则表示输入法打开
        return isOpen;
    }


}
