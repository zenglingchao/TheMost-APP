package com.example.ziyu.themostdemo.Fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ziyu.themostdemo.Activity.MyMagazineActivity;
import com.example.ziyu.themostdemo.Adapter.MineAdapter;
import com.example.ziyu.themostdemo.Base.BaseFragment;
import com.example.ziyu.themostdemo.R;

import java.util.Arrays;

import butterknife.Bind;

/**
 * Created by Ziyu on 2016/11/16.
 */

public class MineFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    @Bind(R.id.mineList)
    ListView listView;
    private MineAdapter adapter;

    String[] titles = {"我的画报","我关注的设计师","我的心愿单","我的消息"};

    @Override
    public int getContentId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void init(View view) {
        adapter = new MineAdapter(getContext());
        listView.setAdapter(adapter);
        adapter.addDatas(Arrays.asList(titles));
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                Intent intent  = new Intent(getActivity(),MyMagazineActivity.class);
                startActivity(intent);
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }



    }
}
