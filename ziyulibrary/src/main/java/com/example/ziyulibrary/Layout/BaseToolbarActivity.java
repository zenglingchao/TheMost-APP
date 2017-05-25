package com.example.ziyulibrary.Layout;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ziyulibrary.Base.BaseActivity;
import com.example.ziyulibrary.R;



/**
 * com.example.ziyu.day37_qqdemo
 * Created by ziyu on 2016/10/18 .
 */

public abstract class BaseToolbarActivity extends BaseActivity {

    public Toolbar getToolbar() {
        return toolbar;
    }

    private Toolbar toolbar;
    private ToolbarBuilder builder;
    private TextView tv_title,tv_menu,tv_subText;
    private ImageView iv_avatar,iv_overflow;

    public ImageView getIv_avatar() {
        return iv_avatar;
    }

    private View contentView;

    @Override
    public View getContentView() {
        //设置要组合的布局
        builder = new ToolbarBuilder(this)
                .setBaseView(getContentId())
                .setToolbar(R.layout.default_toolbar, R.id.toolbar);

        toolbar = builder.getToolbar();
        contentView = builder.create();
        return contentView;
    }

    public View getRootView(){
        return contentView;
    }

    @Override
    public void init() {
        toolbar.setTitle(""); //toolbar默认的title
        tv_title = (TextView)findViewById(R.id.title);
        tv_menu = (TextView) findViewById(R.id.menu);
        tv_subText = (TextView) findViewById(R.id.subText);
        iv_avatar = (ImageView) findViewById(R.id.avatar);
        iv_overflow = (ImageView) findViewById(R.id.addIcon);
        setSupportActionBar(getToolbar());
    }

    public BaseToolbarActivity initTitle(String context){
        tv_title.setText(context);
        return this;
    }
    public BaseToolbarActivity initOption(String option){
        iv_overflow.setVisibility(View.GONE);
        tv_menu.setVisibility(View.VISIBLE);
        tv_menu.setText(option);
        return this;
    }
    public BaseToolbarActivity initSubText(String subText){
        tv_subText.setText(subText);
        return this;
    }

    public BaseToolbarActivity initImage(boolean hasBack){
        if(hasBack){
            toolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow_down_black_24dp);
        }
        iv_avatar.setVisibility(hasBack ? View.GONE : View.VISIBLE);
        return this;
    }
    public BaseToolbarActivity initOverflowIcon(boolean hasIcon){
        iv_overflow.setVisibility(hasIcon ? View.VISIBLE : View.GONE);
        tv_menu.setVisibility(hasIcon ? View.GONE : View.VISIBLE);
        return this;
    }
    public BaseToolbarActivity setOptionIconListener(View.OnClickListener listener) {
        iv_overflow.setOnClickListener(listener);
        return this;
    }
    public BaseToolbarActivity setOptionListener(View.OnClickListener listener){
        tv_menu.setOnClickListener(listener);
        return this;
    }
    public BaseToolbarActivity setAvatarListener(View.OnClickListener listener){
        iv_avatar.setOnClickListener(listener);
        return this;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
