package settings.mtk.diggisin.com.settingstest;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;

/**
 * Explain:
 * <p>
 * Created by Ziyu on 2017/3/4.
 * 13:31
 */

public class CommonDialog {

    LayoutInflater infalter;
    Context context;

    TextView title;
    TextView nagative_btn;
    TextView positive_btn;
    TextView content;

    Dialog dialog;

    public CommonDialog(Context context) {

        this.context = context;
        infalter = LayoutInflater.from(context);

    }

    public  void init(){
     /*   View view = infalter.inflate(R.layout.common_dialog);
        title = view.findViewById(R.layout.title);
        content = view.findViewById(R.layout.content);
        nagative_btn = view.findViewById(R.layout.nagative_btn);
        positive_btn = view.findViewById(R.layout.tive_btn);*/

//        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        builder.setView();
//
//        Dialog dialog = new Dialog(this,R.style.AppTheme);
    }
}
