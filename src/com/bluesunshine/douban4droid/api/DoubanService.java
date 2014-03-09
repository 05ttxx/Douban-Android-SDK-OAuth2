package com.bluesunshine.douban4droid.api;

import java.util.List;

import org.apache.http.NameValuePair;

import com.bluesunshine.douban4droid.utils.AsyncDoubanRunner;
import com.bluesunshine.douban4droid.utils.RequestListener;

/**
 * 
 * @author hao.wen <wenhao7704@gmail.com>
 * 
 * 豆瓣API基类：存放access_token和异步请求方法
 * 在调用API时，必须存在access_token
 * 
 */
public abstract class DoubanService {

	public static final String HTTPMETHOD_POST = "POST";
	public static final String HTTPMETHOD_GET = "GET";
	protected String mAccessToken;

	protected DoubanService(String accessToken) {
		this.mAccessToken = accessToken;
	}

	/**
	 * 
	 * 网络获取数据
	 * 
	 * @param url	豆瓣api url
	 * @param params	NameValuePair参数
	 * @param httpMethod	GET或POST请求方式
	 * @param listener	回调
	 */
	protected void request(final String url, final List<NameValuePair> params,
			final String httpMethod, final String token, RequestListener listener) {
		
		AsyncDoubanRunner.request(url, params, httpMethod, token, listener);
	}
}
