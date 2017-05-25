package com.example.ziyu.themostdemo.Activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.ziyu.themostdemo.Adapter.BinnerPagerAdapter;
import com.example.ziyu.themostdemo.Adapter.CommentListAdapter;
import com.example.ziyu.themostdemo.Adapter.ProductListAdapter;
import com.example.ziyu.themostdemo.Base.SwipeBackActivity;
import com.example.ziyu.themostdemo.Constants;
import com.example.ziyu.themostdemo.Entity.ProductInfoEntity;
import com.example.ziyu.themostdemo.R;
import com.example.ziyu.themostdemo.Util.RetrofitUtil;
import com.example.ziyu.themostdemo.Weight.SmileView;
import com.google.gson.Gson;

import java.util.List;

import butterknife.Bind;

/**
 * Created by Ziyu on 2016/11/2.
 */

public class ProductInfoActivity extends SwipeBackActivity implements RetrofitUtil.DownListener {

    private int id;
    private BinnerPagerAdapter binnerAdapter;
    private CommentListAdapter commentAdapter;
    private ProductListAdapter productAdapter;

    @Bind(R.id.smileView)
    SmileView smile;
    @Bind(R.id.imagePager)
    ViewPager imagePager;
    @Bind(R.id.product_imageLayout)
    LinearLayout imagelayout;
    @Bind(R.id.product_disc)
    TextView productDisc;
    @Bind(R.id.product_title)
    TextView productTitle;
    @Bind(R.id.product_labelLayout)
    LinearLayout labelLayout;
    @Bind(R.id.designer_avatar)
    ImageView desigenrAvatar;
    @Bind(R.id.designer_name)
    TextView designerName;
    @Bind(R.id.designer_label)
    TextView designerLabel;
    @Bind(R.id.designer_disc)
    TextView designerDisc;
    @Bind(R.id.attention)
    CheckBox attention;
    @Bind(R.id.productList)
    GridView productLsit;
    @Bind(R.id.commentTitle)
    TextView commentTitle;
    @Bind(R.id.commentList)
    ListView commentList;
    @Bind(R.id.look_more)
    Button lookMore;
    @Bind(R.id.allComment)
    Button allComment;


    @Override
    public int getContentId() {
        return R.layout.activity_product_info;
    }

    @Override
    public View getContentView() {
        return null;
    }

    @Override
    public void init() {
        super.init();
        Intent intent = getIntent();
        id = intent.getIntExtra("id",0);

        //Viewpager
        binnerAdapter = new BinnerPagerAdapter(this);
        imagePager.setAdapter(binnerAdapter);
        imagePager.setOverScrollMode(View.OVER_SCROLL_NEVER);
        //Comment
        commentAdapter = new CommentListAdapter(this);
        commentList.setAdapter(commentAdapter);
        commentList.setFocusable(false);
        //Product
        productAdapter = new ProductListAdapter(this);
        productLsit.setAdapter(productAdapter);
        productLsit.setFocusable(false);
        //smile
        smile.setDefalutBottom(20).setDividerMargin(60).notifyChange();
    }

    @Override
    public void loadData() {
        String url = String.format(Constants.PRODUCT_INFO,id);
        Log.d("print", "loadData: "+ url);
        new RetrofitUtil(this).setDownListener(this).downJson(url,0x001);
    }

    @Override
    public Object paresJson(String json, int requestCode) {
        return new Gson().fromJson(json, ProductInfoEntity.class);

    }

    @Override
    public void downSucc(Object object, int requestCode) {
        ProductInfoEntity entity = (ProductInfoEntity) object;
        binnerAdapter.setDatas(entity.getData().getCover_images());
        productAdapter.setDatas(entity.getData().getRefer_products());
        commentAdapter.addDatas(entity.getData().getComments());
        productTitle.setText(entity.getData().getName());
        productDisc.setText(entity.getData().getDesc());
        initTypes(entity.getData().getDesc_types());
        initImageLayout(entity.getData().getImages());

        Glide.with(this).load(entity.getData().getDesigner().getAvatar_url()).into(desigenrAvatar);
        designerName.setText(entity.getData().getDesigner().getName());
        designerLabel.setText(entity.getData().getDesigner().getLabel());
        designerDisc.setText(entity.getData().getDesigner().getDescription());

        smile.setNum(entity.getData().getLike_user_num(),entity.getData().getUnlike_user_num());
        commentTitle.setText("评论（"+entity.getData().getComment_num() + ")");
    }

    private void initTypes(List<ProductInfoEntity.DataBean.DescTypesBean> desc_types) {
        for (int i = 0; i < desc_types.size(); i++) {
            TextView tv = new TextView(this);
            ImageView image = new ImageView(this);
            image.setPadding(0,0,30,0);
            tv.setPadding(0,10,0,0);
            tv.setTextSize(16);
            LinearLayout layout = new LinearLayout(this);
            tv.setText(desc_types.get(i).getDesc());
            Glide.with(this)
                    .load(desc_types.get(i).getImage_url())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(image);
            layout.setOrientation(LinearLayout.HORIZONTAL);
            layout.setPadding(0,20,0,0);
            layout.addView(image, 100,100);
            layout.addView(tv,LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            labelLayout.addView(layout,LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        }
    }

    private void initImageLayout(List<String> list) {

        for (int i = 0; i < list.size(); i++) {
            ImageView image = new ImageView(this);
            image.setPadding(0,20,0,20);
            Glide.with(this)
                    .load(list.get(i))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .into(image);
            imagelayout.addView(image,LinearLayout.LayoutParams.MATCH_PARENT,1000);
        }
    }

}
