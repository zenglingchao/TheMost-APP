package settings.mtk.diggisin.com.settingstest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

/**
 * Explain:
 * <p>
 * Created by Ziyu on 2017/3/2.
 * 0:28
 */
public class CommonSettingFragment extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private LinearLayout itme_wifi;
    private LinearLayout item_bluetooth;
    private LinearLayout item_network;
    private LinearLayout item_airMode;

    private ToggleButton switch_wifi;
    private ToggleButton switch_bluetooth;
    private ToggleButton switch_netWork;
    private ToggleButton switch_airMode;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_common,null);
        initView(view);
        initDatas();
        initListener();
        return view;
    }
    private void initView(View view){
        itme_wifi = (LinearLayout) view.findViewById(R.id.item_wifi);
        item_bluetooth = (LinearLayout) view.findViewById(R.id.item_bluetooth);
        item_network = (LinearLayout) view.findViewById(R.id.item_network);
        item_airMode = (LinearLayout) view.findViewById(R.id.item_air_mode);

        switch_wifi = (ToggleButton) view.findViewById(R.id.switch_wifi);
        switch_bluetooth = (ToggleButton) view.findViewById(R.id.switch_bluetooth);
        switch_netWork = (ToggleButton) view.findViewById(R.id.switch_network);
        switch_airMode = (ToggleButton) view.findViewById(R.id.switch_air_mode);
    }

    private void initDatas() {
    }

    private void initListener() {
        itme_wifi.setOnClickListener(this);
        item_bluetooth.setOnClickListener(this);

        switch_wifi.setOnCheckedChangeListener(this);
        switch_bluetooth.setOnCheckedChangeListener(this);
        switch_netWork.setOnCheckedChangeListener(this);
        switch_airMode.setOnCheckedChangeListener(this);
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_wifi :
                break;
            case R.id.item_bluetooth :
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.switch_wifi :
                wifiSwitchClick(isChecked);
                break;
            case R.id.switch_bluetooth :
                bluetoothSwitchClick(isChecked);
                break;
            case R.id. switch_network :
                networkSwtichClick(isChecked);
                break;
            case R.id.switch_air_mode :
                airModeSwitchClick(isChecked);
                break;
        }
    }

    private void airModeSwitchClick(boolean isChecked) {
        if (isChecked) {

        }
        else {

        }
    }

    private void wifiSwitchClick(boolean isChecked) {
        if (isChecked) {

        }
        else {

        }
    }

    private void bluetoothSwitchClick(boolean isChecked) {
        if (isChecked) {

        }
        else {

        }
    }

    private void networkSwtichClick(boolean isChecked) {
        if (isChecked) {

        }
        else {

        }
    }


}
