package com.example.ziyu.themostdemo.Fragment;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.ziyu.themostdemo.Adapter.MagazineAdapter;
import com.example.ziyu.themostdemo.Base.BaseFragment;
import com.example.ziyu.themostdemo.Constants;
import com.example.ziyu.themostdemo.Entity.MagazineEntity;
import com.example.ziyu.themostdemo.Activity.MagazineInfoActivity;
import com.example.ziyu.themostdemo.R;
import com.example.ziyu.themostdemo.Util.RetrofitUtil;
import com.google.gson.Gson;
import com.wirelesspienetwork.overview.views.Overview;

import java.util.Collections;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Ziyu on 2016/10/24.
 */

@RequiresApi(api = Build.VERSION_CODES.M)
public class MagazineFragment extends BaseFragment implements RetrofitUtil.DownListener, Overview.RecentsViewCallbacks {

    @Bind(R.id.stackView)
    Overview stack;
    private MagazineAdapter adapter;

    private int page = 0;
    private boolean isLoad = true;
    private boolean isLast = false;
    private List<MagazineEntity.DataBean.ArticlesBean> articles;

    @Override
    public int getContentId() {
        return R.layout.fragment_magazine;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void init(View view) {
        Log.d("print", "init: ________________!!!!!!!!!!!!!!!!!!!!");
        //设置overView
        stack.setCallbacks(this); //添加手势回调
    }

    @Override
    public void loadData() {
        page++;
        String url = String.format(Constants.MAGAZINE_URL, page);
        Log.d("print", "loadData: " + page);
        new RetrofitUtil(getContext()).setDownListener(this).downJson(url, 0x001);

    }

    @Override
    public Object paresJson(String json, int requestCode) {
        return new Gson().fromJson(json, MagazineEntity.class);
    }

    @Override
    public void downSucc(Object object, int requestCode) {
        final MagazineEntity entity = (MagazineEntity) object;
        articles = entity.getData().getArticles();
        if (articles.isEmpty()) {
            Toast.makeText(getContext(), "没有数据了", Toast.LENGTH_SHORT).show();
            page = 0;
            loadData();
            return;
        }
        //对list执行倒序
        Collections.reverse(articles);
        adapter = new MagazineAdapter(articles);
        stack.setTaskStack(adapter);

        isLoad = false;
    }

    @Override
    public void onCardDismissed(int position) {
        Log.d("print", "onCardDismissed: " + position);
    }

    //卡片移除完时记载下一页
    @Override
    public void onAllCardsDismissed() {
        loadData();
    }

    //添加一个借口回调方法,滑到顶部时加载下一页
    @Override
    public void onScrollChanged(float f) {
        Log.d("print", "onScrollChanged: " + f);
        //下滑
        if (f < -0.02f && !isLoad) {
            loadData();
            isLoad = true;
            return;
        }
        //上滑
        if (f > 7.9f && !isLoad && page >= 2) {
            Toast.makeText(getContext(), "正在加载", Toast.LENGTH_SHORT).show();
            page = page-2;
            loadData();
            isLoad = true;
            return;
        }
      /* //最后一页 f小于0.7
        if(isLast && isLoad && f >0.7f){
            page = page-2;
            loadData();
            isLast = false;
            isLoad = false;
            return;
        }*/
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(getActivity(), MagazineInfoActivity.class);
        intent.putExtra("id",articles.get(position).getId());
        startActivity(intent);
        //设置切换动画，从右边进入，左边退出
        getActivity().overridePendingTransition(R.anim.slde_in, R.anim.slde_out);
    }

}
