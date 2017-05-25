package com.example.ziyu.themostdemo.Activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ziyu.themostdemo.Adapter.MyMagazineAdapter;
import com.example.ziyu.themostdemo.Base.BaseActivity;
import com.example.ziyu.themostdemo.Constants;
import com.example.ziyu.themostdemo.DB.DataBaseUtil;
import com.example.ziyu.themostdemo.Entity.MagazineInfoEntity;
import com.example.ziyu.themostdemo.R;
import com.example.ziyu.themostdemo.Util.RetrofitUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Ziyu on 2016/11/18.
 */
public class MyMagazineActivity extends BaseActivity implements RetrofitUtil.DownListener, AdapterView.OnItemClickListener {


    @Bind(R.id.magazineList)
    ListView listView;

    private MyMagazineAdapter adapter;

    @Override
    public int getContentId() {
        return R.layout.activity_my_magazine;
    }

    @Override
    public View getContentView() {
        return null;
    }

    @Override
    public void init() {
        List<Integer> magazineList = new DataBaseUtil().getInstance(this).getMagazineList();
        for (int i = 0; i < magazineList.size(); i++) {
            String url = String.format(Constants.MAGAZINE_DETAIL,magazineList.get(i));
            new RetrofitUtil(this).setDownListener(this).downJson(url,0x001);
        }
        adapter = new MyMagazineAdapter(this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public Object paresJson(String json, int requestCode) {
        return new Gson().fromJson(json, MagazineInfoEntity.class);
    }

    @Override
    public void downSucc(Object object, int requestCode) {
        List<MagazineInfoEntity> datas = new ArrayList<>();
        datas.add((MagazineInfoEntity) object);
        adapter.addDatas(datas);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(MyMagazineActivity.this, MagazineInfoActivity.class);
        MagazineInfoEntity item = (MagazineInfoEntity) adapter.getItem(position);
        intent.putExtra("id",item.getData().getId());
        startActivity(intent);
        //设置切换动画，从右边进入，左边退出
        overridePendingTransition(R.anim.slde_in, R.anim.slde_out);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        listView.removeAllViews();
        init();
    }
}
