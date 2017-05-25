package com.example.ziyulibrary.Util;

public class CommonUtils {




	/**
	 * 检查SD卡是否存在
	 */
	public static boolean checkSdCard() {
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED))
			return true;
		else
			return false;
	}

}
