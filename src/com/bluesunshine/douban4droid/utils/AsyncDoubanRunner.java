package com.bluesunshine.douban4droid.utils;

import java.util.List;

import org.apache.http.NameValuePair;

import com.bluesunshine.douban4droid.model.app.DoubanException;

public class AsyncDoubanRunner {

	/**
	 * 请求接口数据，并在获取到数据后通过RequestListener将responsetext回传给调用者
	 * 
	 * @param url
	 *            服务器地址
	 *            
	 * @param params
	 *            存放参数的容器
	 * 
	 * @param method
	 *            请求方式
	 *            
	 * @param token
	 *            Oauth Token
	 *            
	 * @param listener
	 *            回调对象
	 */

	public static void request(final String url,
			final List<NameValuePair> params, final String method, final String token,
			final RequestListener listener) {
		
		new Thread() {
			@Override
			public void run() {

				String resp = null;
				try {
					
					resp = new HttpManager().openUrl(url, params, method, token);
					listener.onComplete(resp);
				} catch (DoubanException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					listener.onError(e);
				}
				
			}
		}.start();

	}

}
