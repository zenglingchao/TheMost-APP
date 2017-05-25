package com.example.ziyu.themostdemo.Fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.ziyu.themostdemo.Activity.DesignerInfoActivity;
import com.example.ziyu.themostdemo.Adapter.DesignerListAdapter;
import com.example.ziyu.themostdemo.Base.BaseFragment;
import com.example.ziyu.themostdemo.Entity.DesignerEntity;
import com.example.ziyu.themostdemo.R;
import com.example.ziyu.themostdemo.Util.AnimationUtil;
import com.example.ziyu.themostdemo.Util.RetrofitUtil;
import com.google.gson.Gson;

import butterknife.Bind;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;

/**
 * Created by Ziyu on 2016/10/31.
 */

public class DesignerPageFragment extends BaseFragment implements RetrofitUtil.DownListener, DesignerListAdapter.OnItemClickListener {

    @Bind(R.id.recycleView)
    RecyclerView recyclerView;

    @Bind(R.id.ptr_frame)
    PtrFrameLayout ptrFrameLayout;

    private int page = 1;
    String URL;
    private DesignerListAdapter adapter;


    public static DesignerPageFragment getInstance(String url){
        DesignerPageFragment fragment = new DesignerPageFragment();
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
        adapter = new DesignerListAdapter(getContext());
        adapter.setOnItemClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        recyclerView.setOverScrollMode(android.support.v7.widget.RecyclerView.OVER_SCROLL_NEVER);
        initPtr();
    }
    private boolean isLoad;
    private void initPtr() {
        ptrFrameLayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame,content,header);
            }

            @Override
            public void onRefreshBegin(final PtrFrameLayout frame) {
                downDatas(true);
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
    public void loadData() {
        downDatas(true);
    }

    /**
     *下载数据
     * @param isRefresh
     *  下拉刷新时为true, refresh时为false
     */
    public void downDatas(boolean isRefresh){

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
        //String realURL = String.format(Constants.DISCOVER_CONTENT,id,page);
        new RetrofitUtil(getContext()).setDownListener(this).downJson(URL,request);
    }

    @Override
    public Object paresJson(String json, int requestCode) {
        return new Gson().fromJson(json.toString(),DesignerEntity.class);
    }

    @Override
    public void downSucc(Object object, int requestCode) {
        DesignerEntity entity = (DesignerEntity) object;
        if(requestCode == 0x001){
            adapter.setDatas(entity.getData().getDesigners());
        }
        if (requestCode == 0x002){
            adapter.addDatas(entity.getData().getDesigners());
            isLoad = false;
        }
    }

    @Override
    public void onItemClick(View view,int position){
        Intent intent = new Intent(getActivity(), DesignerInfoActivity. class);
        intent.putExtra("id",adapter.getDesignerId(position));
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.slde_in, R.anim.slde_out);
    }

    @Override
    public void onScrollBottom() {
        if (!isLoad && adapter.getItemCount()>1){
            downDatas(false);
            isLoad = true;
        }
    }
}
