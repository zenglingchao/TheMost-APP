package settings.mtk.diggisin.com.settingstest.Utils;

import android.content.Context;

/**
 * Explain:
 * <p>
 * Created by Ziyu on 2017/3/2.
 * 0:48
 */

public class ScreenUtils {
    /**
     * 获得通知栏的高度
     * @return
     */
    public static int getStatusHeight(Context context){
        int resid = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if(resid > 0){
            return context.getResources().getDimensionPixelSize(resid);
        }
        return -1;
    }

}
