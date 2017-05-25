package com.example.ziyulibrary.Util.DownUtil;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 
 * @author Ken
 *
 */
public class AbsAsyncTask extends AsyncTask<String, Void, Object> {

	private DownType downType;
	private ImageView iv;
	private OnDownListener onDownListener;
	
	public AbsAsyncTask(DownType downType){
		this.downType = downType;
	}
	
	
	@Override
	protected Object doInBackground(String... params) {
		byte[] bs = getByteArray(params[0]);
		if (bs != null) {
			switch (downType) {
				case JSON:
					String json = new String(bs);
					if(onDownListener != null){
						Object datas = onDownListener.downJSON(json);
						return datas;
					}
					break;
				case IMAGE:
					Bitmap bitmap = BitmapFactory.decodeByteArray(bs, 0, bs.length);
					return bitmap;
			}
		}
		return null;
	}
	
	@Override
	protected void onPostExecute(Object result) {
		if(result != null){
			switch (downType) {
				case JSON:
					if(onDownListener != null){
						onDownListener.paresJSON(result);
					}
					break;
				case IMAGE:
					Bitmap bitmap = (Bitmap) result;
					if(iv != null){
						iv.setImageBitmap(bitmap);
					}
					break;
			}
		}
	}
	
	public AbsAsyncTask with(ImageView iv){
		this.iv = iv;
		return this;
	}
	
	public static enum DownType{
		JSON,
		IMAGE
	}
	
	/**
	 * @return
	 */
	private byte[] getByteArray(String urlStr){
		InputStream in = null;
		ByteArrayOutputStream out = null;
		try {
			URL url = new URL(urlStr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setReadTimeout(3000);
			
			conn.connect();
			
			if(conn.getResponseCode() == 200){
				in = conn.getInputStream();
				out = new ByteArrayOutputStream();
				
				byte[] buffer = new byte[1024 * 8];
				int len = 0;
				while((len = in.read(buffer)) != -1){
					out.write(buffer, 0, len);
				}
				
				return out.toByteArray();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null){
					in.close();
				}
				
				if(out != null){
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * List<News>
	 * 
	 * List<House>
	 * @author Ken
	 *
	 */
	public interface OnDownListener{
		Object downJSON(String json);
		void paresJSON(Object datas);
	}

	/**
	 * @param onDownListener
	 */
	public AbsAsyncTask setOnDownListener(OnDownListener onDownListener) {
		this.onDownListener = onDownListener;
		return this;
	}
}
