package com.example.ziyulibrary.Layout;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ziyulibrary.Base.BaseActivity;

/**
 * Created by ziyu on 2016/8/23.
 */
public abstract class ToolbarActivity extends BaseActivity {

    public static final int TOOLBAR_ONLY_SEARCH_WITH_IMAGE   = 1;
    public static final int TOOLBAR_ONLY_MENU_WITH_IMAGE     = 2;
    public static final int TOOLBAR_NAVIGATION_WITH_TITLE    = 3;

    private ToolbarHelper toolbarHelper;
    public Toolbar toolbar;
    private ImageView appImage;
    private TextView title;
    private Menu menu;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {

        toolbarHelper = new ToolbarHelper(this,layoutResID);
        toolbar = toolbarHelper.getToolbar();
        toolbar.setTitle("");
        setContentView(toolbarHelper.getContentView());

        /*此处执行后无法再修改toolbar title*/
       // setSupportActionBar(toolbar);

        /*自定义的操作*/
        onCreateCustomToolbar(toolbar);
    }

   // public abstract void setToolbar(int toolbarlayout);


    //自定义的toolbar操作
    public void onCreateCustomToolbar(Toolbar toolbar) {
        //意义不明
       // toolbar.setContentInsetsRelative(0,0);
    }

    public void initToolbar(String titleStr,boolean navigation,boolean withImage){
      /*  title = findViewById(R.id.toolbarTitle);
        appImage = findId(R.id.toolbarImage);

        if(!titleStr.equals("")){
            title.setText(titleStr);
        }
        if(navigation){
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        }
        if(!withImage){
            appImage.setVisibility(View.GONE);
        }*/
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
