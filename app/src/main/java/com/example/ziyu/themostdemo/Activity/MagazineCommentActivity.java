package com.example.ziyu.themostdemo.Activity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ziyu.themostdemo.Adapter.CommentAdapter;
import com.example.ziyu.themostdemo.Base.BaseActivity;
import com.example.ziyu.themostdemo.Entity.MagazineInfoEntity;
import com.example.ziyu.themostdemo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Ziyu on 2016/11/2.
 */

public class MagazineCommentActivity extends BaseActivity {


    @Bind(R.id.commentList)
    ListView commentList;
    @Bind(R.id.edit)
    EditText edit;


    private CommentAdapter adapter;

    @Override
    public int getContentId() {
        return R.layout.activity_magazine_comment;
    }

    @Override
    public View getContentView() {
        return null;
    }

    @Override
    public void init() {
        adapter = new CommentAdapter(this,R.layout.item_comment2);
        Intent intent = getIntent();
        if(intent.getBooleanExtra("isEdit",false)){
            edit.postDelayed(new Runnable() {
                @Override
                public void run() {
                    showSoftInput();
                }
            },300);
        }
        adapter.addDatas((List<MagazineInfoEntity.DataBean.CommentsBean>) intent.getSerializableExtra("comment"));
        commentList.setAdapter(adapter);
    }

    public void backClick(View view){
        this.finish();
        //设置Activity退出的动画
        this.overridePendingTransition(0, R.anim.slide_finish);
        hideSoftInputView();
    }

    public void sendClick(View view){
        String s = edit.getText().toString();
        if (s.equals("")){
            Toast.makeText(this, "评论不能为空", Toast.LENGTH_SHORT).show();
        }else{
            List<MagazineInfoEntity.DataBean.CommentsBean> list = new ArrayList<>();
            MagazineInfoEntity.DataBean.CommentsBean comment = new MagazineInfoEntity.DataBean.CommentsBean();
            MagazineInfoEntity.DataBean.CommentsBean.AuthorBean author = new MagazineInfoEntity.DataBean.CommentsBean.AuthorBean();
            author.setUsername("admin");
            author.setAvatar_url("");
            comment.setAuthor(author);
            comment.setContent(s);
            comment.setCreated_at(System.currentTimeMillis());
            list.add(comment);
            adapter.addDatas(list);
        }
    }
}
