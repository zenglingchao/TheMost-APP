package com.example.ziyulibrary.Weight.FlipStackView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ziyulibrary.R;

/**
 * Created by Ziyu on 2016/10/24.
 */

public class MagazinePagerFragment extends android.support.v4.app.Fragment {
    private View view;
    ImageView avatar, image;
    TextView title, subTitle, username;

    public static MagazinePagerFragment getInstance(MagazineEntity.DataBean.ArticlesBean bean) {
        MagazinePagerFragment fragment = new MagazinePagerFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("bean", bean);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.item_magazine, null);
        username = (TextView) view.findViewById(R.id.username);
        avatar = (ImageView) view.findViewById(R.id.avatar);
        title = (TextView) view.findViewById(R.id.title);
        subTitle = (TextView) view.findViewById(R.id.sub);
        image = (ImageView) view.findViewById(R.id.image);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        MagazineEntity.DataBean.ArticlesBean bean = (MagazineEntity.DataBean.ArticlesBean) bundle.getSerializable("bean");

        username.setText(bean.getAuthor().getUsername());
        title.setText(bean.getTitle());
        subTitle.setText(bean.getSub_title());
        Glide.with(getContext()).load(bean.getAuthor().getAvatar_url()).into(avatar);
        Glide.with(getContext()).load(bean.getImage_url()).into(image);
    }
}
