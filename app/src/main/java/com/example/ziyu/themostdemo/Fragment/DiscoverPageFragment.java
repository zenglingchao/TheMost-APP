package com.example.ziyu.themostdemo.Fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.ziyu.themostdemo.Activity.ProductInfoActivity;
import com.example.ziyu.themostdemo.Adapter.DiscoverListAdapter;
import com.example.ziyu.themostdemo.Base.BaseFragment;
import com.example.ziyu.themostdemo.Constants;
import com.example.ziyu.themostdemo.Entity.DiscoverEntity;
import com.example.ziyu.themostdemo.R;
import com.example.ziyu.themostdemo.Util.AnimationUtil;
import com.example.ziyu.themostdemo.Util.RetrofitUtil;
import com.google.gson.Gson;

import butterknife.Bind;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;

/**
 * Created by Ziyu on 2016/10/26.
 */

public class DiscoverPageFragment extends BaseFragment implements RetrofitUtil.DownListener, DiscoverListAdapter.OnItemClickListener {

    @Bind(R.id.recycleView)
    RecyclerView recyclerView;
    @Bind(R.id.ptr_frame)
    PtrFrameLayout ptrFrameLayout;
    private LinearLayoutManager manager;

    private DiscoverListAdapter adapter;
    private String url;
    private int id;
    private int page = 1;
    public static DiscoverPageFragment getInstance(int id,String url){
        DiscoverPageFragment fragment = new DiscoverPageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url",url);
        bundle.putInt("id",id);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getContentId() {
        return R.layout.fragment_pager;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        url = bundle.getString("url");
        id = bundle.getInt("id");
        downDatas(id,true);

        manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        adapter = new DiscoverListAdapter(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setOverScrollMode(android.support.v7.widget.RecyclerView.OVER_SCROLL_NEVER);
        //设置点击监听
        adapter.setOnItemClickListener(this);
        initPtr();
    }

    private boolean isLoad = false;
    /**
     *下载数据
     * @param isRefresh
     *  下拉刷新时为true, refresh时为false
     */
    public void downDatas(int id,boolean isRefresh){

        int request;
        int page;
        if(isRefresh){
            page = 1;
            request = 0x001;
        }else{
            this.page ++;
            page = this.page;
            request = 0x002;
        }
        String realURL;
        if(id == -1){
            realURL = url;
        }else{
            realURL = String.format(Constants.DISCOVER_CONTENT,id,page);
        }
        new RetrofitUtil(getContext()).setDownListener(this).downJson(realURL,request);
    }

    private void initPtr() {
        ptrFrameLayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                if (manager.findFirstVisibleItemPosition()==0 &&  manager.getChildAt(0).getTop() == 0){
                    return true;
                }
                return false;
            }

            @Override
            public void onRefreshBegin(final PtrFrameLayout frame) {
                downDatas(id,true);
                frame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                      ptrFrameLayout.refreshComplete();
                    }
                },2400);
            }
        });

    ptrFrameLayout.addPtrUIHandler(new PtrUIHandler() {
            @Override
            public void onUIReset(PtrFrameLayout frame) {
            }

            @Override
            public void onUIRefreshPrepare(PtrFrameLayout frame) {
                LinearLayout view = (LinearLayout) frame.getHeaderView();
                ImageView image = (ImageView) view.getChildAt(0);
                image.setScaleX(0.3f);
                image.setScaleY(0.3f);
                Log.d("print", "onUIPositionChange: " + image.getY());
                AnimatorSet animatorSet = new AnimatorSet();//组合动画
                ObjectAnimator scaleX = ObjectAnimator.ofFloat(image, "scaleX", 0.3f, 1.0f);
                ObjectAnimator scaleY = ObjectAnimator.ofFloat(image, "scaleY", 0.3f, 1.0f);

                animatorSet.setDuration(1000);
                animatorSet.setStartDelay(200);
                animatorSet.play(scaleX).with(scaleY);//两个动画同时开始
                animatorSet.start();
            }

            @Override
            public void onUIRefreshBegin(PtrFrameLayout frame) {
                LinearLayout view = (LinearLayout) frame.getHeaderView();
                ImageView image = (ImageView) view.getChildAt(0);
                AnimationUtil.LoadRouteAnimaion(image);
            }

            @Override
            public void onUIRefreshComplete(PtrFrameLayout frame) {
                LinearLayout view = (LinearLayout) frame.getHeaderView();
                ImageView image = (ImageView) view.getChildAt(0);
                AnimatorSet animatorSet = new AnimatorSet();//组合动画
                ObjectAnimator scaleX = ObjectAnimator.ofFloat(image, "scaleX", image.getScaleX(), 0.3f);
                ObjectAnimator scaleY = ObjectAnimator.ofFloat(image, "scaleY", image.getScaleY(), 0.3f);

                animatorSet.setDuration(300);
                animatorSet.play(scaleX).with(scaleY);//两个动画同时开始
                animatorSet.start();
            }

            @Override
            public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {
            }
        });
    }

    @Override
    public Object paresJson(String json, int requestCode) {
        return new Gson().fromJson(json, DiscoverEntity.class);
    }

    @Override
    public void downSucc(Object object, int requestCode) {
        DiscoverEntity entity = (DiscoverEntity) object;
        if(requestCode == 0x001){
            adapter.setDatas(entity.getData().getProducts());
        }
        if (requestCode == 0x002){
            adapter.addDatas(entity.getData().getProducts());
            isLoad = false;
        }
    }

    @Override
    public void onItemClick(View view,int position){
        Intent intent = new Intent(getActivity(), ProductInfoActivity. class);
        intent.putExtra("id",adapter.getProductId(position));
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.slde_in, R.anim.slde_out);
    }

    @Override
    public void onScrollBottom() {
        if (!isLoad && adapter.getItemCount()>1){
            downDatas(id,false);
            isLoad = true;
        }
    }
}
