package com.example.ziyu.themostdemo.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.ziyu.themostdemo.Base.BaseFragment;
import com.example.ziyu.themostdemo.Entity.DesignerInfoEntity;
import com.example.ziyu.themostdemo.R;
import com.example.ziyu.themostdemo.Util.RetrofitUtil;
import com.google.gson.Gson;

/**
 * Created by Ziyu on 2016/10/31.
 */

public class MyDesignerPageFragment extends BaseFragment implements RetrofitUtil.DownListener {

    String URL;

    public static MyDesignerPageFragment getInstance(String url){
        MyDesignerPageFragment fragment = new MyDesignerPageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url",url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getContentId() {
        return R.layout.fragment_pager;
    }

    @Override
    public void init(View view) {
        Bundle bundle = getArguments();
        URL = bundle.getString("url");
    }

    @Override
    public void loadData() {
        new RetrofitUtil(getContext()).setDownListener(this).downJson(URL,0x001);
    }

    @Override
    public Object paresJson(String json, int requestCode) {
        return new Gson().fromJson(json.toString(), DesignerInfoEntity.class);
    }

    @Override
    public void downSucc(Object object, int requestCode) {
        DesignerInfoEntity entity = (DesignerInfoEntity) object;
        Log.d("print", "downSucc: " + entity);
    }
}
