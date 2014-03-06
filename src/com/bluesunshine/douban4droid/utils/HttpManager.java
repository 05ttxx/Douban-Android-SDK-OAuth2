package com.bluesunshine.douban4droid.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;

import com.bluesunshine.douban4droid.api.DoubanService;

/**
 * @author hao.wen <wenhao7704@gmail.com>
 * 
 *         创建网络连接，获取String类型的返回值
 * 
 * */
public class HttpManager {

	public HttpManager() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * 打开网络连接并获取String类型的网络数据
	 * 
	 * @param url
	 * @param method
	 * @param params
	 * @return
	 */
	public String openUrl(String url, List<NameValuePair> params,
			String method, String token) {

		String result = null;
		if (method.equals(DoubanService.HTTPMETHOD_POST)) {
			result = postResponse(url, params, token);
		} else if (method.equals(DoubanService.HTTPMETHOD_GET)) {
			result = getResponse(url, params, token);
		}
		
		return result;
	}

	/**
	 * 
	 * post方式获取网络数据 NOTICE: 需要加入相关的HTTP头部
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	private String getResponse(String url, List<NameValuePair> params,
			String token) {

		HttpClient client = new DefaultHttpClient();
		if (params != null && params.size() > 0) {
			String encodedParams = encodeParameters(params);
			url = url + "?" + encodedParams;
		}

		Debugs.d("wenhao", "getUrl:"+ url);
		HttpGet get = new HttpGet(url);
		get.setHeader("User-Agent", "BlueSunshine - Douban Android SDK");

		if (token != null) {
			get.setHeader("Authorization", "Bearer " + token);
		}

		HttpResponse response = null;
		try {
			response = client.execute(get);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return getResponseString(response);
	}

	/**
	 * 
	 * post的方式获取网络数据
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	private String postResponse(String url, List<NameValuePair> params,
			String token) {

		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);

		try {
			post.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		HttpResponse response = null;
		try {
			response = client.execute(post);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return getResponseString(response);
	}

	/**
	 * 
	 * 添加网络判断，返回网络读取字符串
	 * 
	 * @param response
	 * @return
	 */
	private String getResponseString(HttpResponse response) {

		String result = null;
		StatusLine status = response.getStatusLine();
		int statusCode = status.getStatusCode();

		if (statusCode != 200) {

			return result;
		}
		result = readHttpResponse(response);

		return result;
	}

	/**
	 * 
	 * 读取网络中的数据并返回
	 * 
	 * @param response
	 * @return
	 */
	private static String readHttpResponse(HttpResponse response) {
		String result = "";
		HttpEntity entity = response.getEntity();
		InputStream inputStream;
		try {
			inputStream = entity.getContent();
			ByteArrayOutputStream content = new ByteArrayOutputStream();

			int readBytes = 0;
			byte[] sBuffer = new byte[512];
			while ((readBytes = inputStream.read(sBuffer)) != -1) {
				content.write(sBuffer, 0, readBytes);
			}
			result = new String(content.toByteArray());
			return result;
		} catch (IllegalStateException e) {
		} catch (IOException e) {
		}
		return result;
	}

	/**
	 * 
	 * 获取params中的数据，生成url中需要的参数字符串
	 * 
	 * @param params
	 * @return
	 */
	private static String encodeParameters(List<NameValuePair> params) {
		StringBuilder buf = new StringBuilder();
		int j = 0;
		for (NameValuePair nvp : params) {
			if (j != 0) {
				buf.append("&");
			}
			j++;
			try {
				buf.append(URLEncoder.encode(nvp.getName(), HTTP.UTF_8))
						.append("=")
						.append(URLEncoder.encode(nvp.getValue(), HTTP.UTF_8));
			} catch (java.io.UnsupportedEncodingException ex) {
				System.out.println("Shouldn't go this far");
			}
		}
		return buf.toString();
	}

}
