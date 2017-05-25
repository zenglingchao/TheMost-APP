package com.example.ziyu.themostdemo;

import android.view.View;
import android.widget.RadioGroup;

import com.example.ziyu.themostdemo.Base.BaseActivity;
import com.example.ziyu.themostdemo.Fragment.DesignerFragment;
import com.example.ziyu.themostdemo.Fragment.DiscoverFragment;
import com.example.ziyu.themostdemo.Fragment.MagazineFragment;
import com.example.ziyu.themostdemo.Fragment.MineFragment;

import butterknife.Bind;

/**
 * 首页
 */
public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    @Bind(R.id.group)
    RadioGroup radioGroup;

    @Override
    public int getContentId() {
        return R.layout.activity_main;
    }
    @Override
    public View getContentView() {
        return null;
    }

    @Override
    public void init() {
        radioGroup.setOnCheckedChangeListener(this);
        radioGroup.getChildAt(0).performClick();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch(checkedId){
            case R.id.radio_magazine :
                showFragment(R.id.fragmentHome,new MagazineFragment());
                break;
            case R.id.radio_discover :
                showFragment(R.id.fragmentHome,new DiscoverFragment());
                break;
            case R.id.radio_designer :
                showFragment(R.id.fragmentHome,new DesignerFragment());
                break;
            case R.id.radio_mine :
                showFragment(R.id.fragmentHome,new MineFragment());
                break;
        }
    }
}
