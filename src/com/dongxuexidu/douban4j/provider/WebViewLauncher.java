package com.dongxuexidu.douban4j.provider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.dongxuexidu.douban4j.R;
import com.dongxuexidu.douban4j.api.DoubanService;
import com.dongxuexidu.douban4j.constants.DefaultConfigs;
import com.dongxuexidu.douban4j.model.app.DoubanException;
import com.dongxuexidu.douban4j.utils.AsyncDoubanRunner;
import com.dongxuexidu.douban4j.utils.RequestListener;

/**
 * 
 * @author hao.wen <wenhao7704@gmail.com>
 * 
 *         Oauth登陆界面
 * 
 *         使用方法：
 * 
 *         1. 通过startActivityForResult()启动WebViewLauncher
 * 
 *         2. 将认证url通过Intent的传递给WebViewLauncher 
 *         
 *         3. 登陆认证通过后，将包含token的json通过Intent回传给调用Activity
 * */
public class WebViewLauncher extends Activity {

	public final static int REQUEST_CODE = 100;
	public final static String INTENT_EXTRA_URL = "douban_getcode_url";
	public final static String INTENT_EXTRA_TOKEN = "douban_oauth_token";
	private final String CODE_URL_SUBSTRING = "code=";

	private WebView mWebView;
	private String mUrl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webview);

		/*
		 * 获取豆瓣认证url
		 */
		Intent intent = getIntent();
		mUrl = intent.getStringExtra(INTENT_EXTRA_URL);
		setUpWebView();
	}

	/**
	 * 
	 * 设置WebView
	 * 
	 * @author hao.wen <wenhao7704@gmail.com>
	 * 
	 */
	private void setUpWebView() {

		mWebView = (WebView) findViewById(R.id.ID_LOGIN_WEBVIEW);
		mWebView.setHorizontalScrollBarEnabled(false);
		// mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.setWebViewClient(new DoubanWebViewClient());
		mWebView.loadUrl(mUrl);
	}

	/**
	 * 
	 * 通过code获取包含access_token的JSON数据 
	 * 
	 * Modified by hao.wen 2013-12-5
	 * 
	 * @param code
	 * @param listener
	 */
	private void tradeAccessTokenWithCode(String code, RequestListener listener) {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("client_id", DefaultConfigs.API_KEY));
		params.add(new BasicNameValuePair("client_secret",
				DefaultConfigs.SECRET_KEY));
		params.add(new BasicNameValuePair("redirect_uri",
				DefaultConfigs.ACCESS_TOKEN_REDIRECT_URL));
		params.add(new BasicNameValuePair("grant_type", "authorization_code"));
		params.add(new BasicNameValuePair("code", code));

		AsyncDoubanRunner.request(DefaultConfigs.ACCESS_TOKEN_URL, params,
				DoubanService.HTTPMETHOD_POST, null, listener);
	}

	/**
	 * 获取登陆成功后的回调url并获取包含token的json
	 * 
	 * @author hao.wen <wenhao7704@gmail.com> date: 2013-12-6 上午10:36:59
	 * 
	 */
	private class DoubanWebViewClient extends WebViewClient {

		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			// TODO Auto-generated method stub
			super.onPageStarted(view, url, favicon);

			if (url.startsWith(DefaultConfigs.ACCESS_TOKEN_REDIRECT_URL)) {

				String code = url.substring(url.indexOf(CODE_URL_SUBSTRING)
						+ CODE_URL_SUBSTRING.length());

				tradeAccessTokenWithCode(code, new RequestListener() {

					@Override
					public void onIOException(IOException e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onError(DoubanException e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onComplete(String response) {
						// TODO Auto-generated method stub

						Intent data = new Intent();
						data.putExtra(INTENT_EXTRA_TOKEN, response);
						setResult(REQUEST_CODE, data);
						finish();
					}
				});
			}
		}
	}

}
