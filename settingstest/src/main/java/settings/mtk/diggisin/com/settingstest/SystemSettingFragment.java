package settings.mtk.diggisin.com.settingstest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Explain:
 * <p>
 * Created by Ziyu on 2017/3/2.
 * 0:28
 */
public class SystemSettingFragment extends Fragment implements View.OnClickListener {

    private LinearLayout item_update;
    private LinearLayout item_light;
    private LinearLayout item_audio;
    private LinearLayout item_time;
    private LinearLayout item_memory;
    private LinearLayout item_reset;
    private LinearLayout item_about;

    private TextView tv_time;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_system, null);
        initView(view);
        initListener();
        return view;
    }

    private void initView(View view) {
        item_update = (LinearLayout) view.findViewById(R.id.item_update);
        item_light = (LinearLayout) view.findViewById(R.id.item_light);
        item_audio = (LinearLayout) view.findViewById(R.id.item_audio);
        item_time = (LinearLayout) view.findViewById(R.id.item_time);
        item_memory = (LinearLayout) view.findViewById(R.id.item_memory);
        item_reset = (LinearLayout) view.findViewById(R.id.item_reset);
        item_about = (LinearLayout) view.findViewById(R.id.item_about);

        tv_time = (TextView) view.findViewById(R.id.tv_time);
    }

    private void initListener() {
        item_update.setOnClickListener(this);
        item_light.setOnClickListener(this);
        item_audio.setOnClickListener(this);
        item_time.setOnClickListener(this);
        item_memory.setOnClickListener(this);
        item_reset.setOnClickListener(this);
        item_about.setOnClickListener(this);
    }

    private void initData() {

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_update:
                break;
            case R.id.item_light:
                break;
            case R.id.item_audio:
                break;
            case R.id.item_time:
                break;
            case R.id.item_memory:
                break;
            case R.id.item_reset:
                break;
            case R.id.item_about:
                break;
        }
    }
}
