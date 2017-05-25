package com.example.ziyu.themostdemo.Activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ziyu.themostdemo.Adapter.BinnerPagerAdapter;
import com.example.ziyu.themostdemo.Adapter.ProductGridAdapter;
import com.example.ziyu.themostdemo.Base.SwipeBackActivity;
import com.example.ziyu.themostdemo.Constants;
import com.example.ziyu.themostdemo.Entity.DesignerInfoEntity;
import com.example.ziyu.themostdemo.Entity.ProductEntity;
import com.example.ziyu.themostdemo.Entity.ShopEntity;
import com.example.ziyu.themostdemo.R;
import com.example.ziyu.themostdemo.Util.RetrofitUtil;
import com.example.ziyu.themostdemo.Weight.FlowLayout;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

import static com.example.ziyu.themostdemo.R.id.imagePager;

/**
 * Created by Ziyu on 2016/11/2.
 */

public class DesignerInfoActivity extends SwipeBackActivity implements RetrofitUtil.DownListener {

    @Bind(imagePager)
    ViewPager binner;
    @Bind(R.id.designer_name)
    TextView designerName;
    @Bind(R.id.designer_label)
    TextView designerLabel;
    @Bind(R.id.label_layout)
    FlowLayout flowLayout;
    @Bind(R.id.attentionNum)
    TextView attentionNum;
    @Bind(R.id.concept)
    TextView concept;
    @Bind(R.id.designer_disc)
    TextView designerDisc;
    @Bind(R.id.designer_avatar)
    ImageView designerAvatar;

    @Bind(R.id.olShopImage)
    ImageView shopImage;
    @Bind(R.id.olShopName)
    TextView shopName;
    @Bind(R.id.product_title)
    TextView product_title;
    @Bind(R.id.shop_image)
    ImageView shop_Image;
    @Bind(R.id.city)
    TextView city;
    @Bind(R.id.address)
    TextView address;
    @Bind(R.id.shopTitle)
    TextView shopTitle;
    @Bind(R.id.shopView)
    LinearLayout layout;
    @Bind(R.id.productGrid)
    GridView productView;
    @Bind(R.id.attention)
    CheckBox attention;
    private ProductGridAdapter gridAdapter;


    private int id;
    private BinnerPagerAdapter binnerAdapter;
    private List<String> titles = new ArrayList<>();

    @Override
    public int getContentId() {
        return R.layout.activity_designer_info;
    }

    @Override
    public View getContentView() {
        return null;
    }

    @Override
    public void init() {
        super.init();
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        titles.add("作品");
        titles.add("旗舰门店");
        titles.add("线上购买");

        //banner
        binnerAdapter = new BinnerPagerAdapter(this);
        binner.setAdapter(binnerAdapter);
        binner.setOverScrollMode(View.OVER_SCROLL_NEVER);
        //gridView
        gridAdapter = new ProductGridAdapter(this);
        productView.setAdapter(gridAdapter);

    }


    @Override
    public void loadData() {
        String infoUrl = String.format(Constants.DESIGNER, id);
        String shopUrl = String.format(Constants.DESIGNER_SHOP, id);
        String productUrl = String.format(Constants.DESIGNER_PRODUCT, id);

        new RetrofitUtil(this).setDownListener(this).downJson(infoUrl, 0x001);
        new RetrofitUtil(this).setDownListener(this).downJson(productUrl, 0x003);
        new RetrofitUtil(this).setDownListener(this).downJson(shopUrl, 0x002);
    }

    @Override
    public Object paresJson(String json, int requestCode) {
        switch (requestCode) {
            case 0x001:
                return new Gson().fromJson(json, DesignerInfoEntity.class);
            case 0x002:
                return new Gson().fromJson(json, ShopEntity.class);
            case 0x003:
                return new Gson().fromJson(json, ProductEntity.class);
        }
        return null;
    }

    @Override
    public void downSucc(Object object, int requestCode) {
        switch (requestCode) {
            case 0x001:
                DesignerInfoEntity designer = (DesignerInfoEntity) object;
                binnerAdapter.setDatas(designer.getData().getIntroduce_images());
                Glide.with(this).load(designer.getData().getAvatar_url()).into(designerAvatar);
                designerName.setText(designer.getData().getName());
                designerLabel.setText(designer.getData().getLabel());
                concept.setText(designer.getData().getConcept());
                attentionNum.setText(designer.getData().getFollow_num() + "人关注");
                designerDisc.setText(designer.getData().getDescription());
                initCategories(designer);
                break;
            case 0x002:
                ShopEntity shop = (ShopEntity) object;
                shopName.setText(shop.getData().getOnline_shops().get(0).getName());
                shopName.setTag(shop.getData().getOnline_shops().get(0).getLink_url());
                Glide.with(this).load(shop.getData().getOnline_shop_image()).centerCrop().into(shopImage);
                if (shop.getData().getShops().size()>0){
                    Glide.with(this).load(shop.getData().getShop_image()).centerCrop().into(shop_Image);
                    city.setText(shop.getData().getShops().get(0).getCity());
                    address.setText(shop.getData().getShops().get(0).getAddress());
                }else{
                    shopTitle.setVisibility(View.GONE);
                    layout.setVisibility(View.GONE);
                }
                break;
            case 0x003:
                ProductEntity products = (ProductEntity) object;
                gridAdapter.setDatas(products.getData().getProducts());
                if (gridAdapter.getCount() == 0)
                product_title.setVisibility(View.GONE);
                break;
        }

    }

    private void initCategories(DesignerInfoEntity designer) {
        for (int i = 0; i < designer.getData().getCategories().size(); i++) {
            TextView tv = new TextView(this);
            tv.setText(designer.getData().getCategories().get(i).getName());
            tv.setBackgroundResource(R.drawable.tag_background);
            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams
                            (LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            params.setMargins(30, 15, 30, 15);
            flowLayout.addView(tv, params);
        }
    }

    public void shopClick(View  view){
        Object link = view.getTag();
        Log.d("print", "shopClick: " + link);
    }
}
