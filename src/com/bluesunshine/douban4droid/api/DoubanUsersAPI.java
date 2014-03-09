package com.bluesunshine.douban4droid.api;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.bluesunshine.douban4droid.constants.RequestUrls;
import com.bluesunshine.douban4droid.model.app.DoubanException;
import com.bluesunshine.douban4droid.utils.ErrorHandler;
import com.bluesunshine.douban4droid.utils.RequestListener;

/**
 * 
 * @author hao.wen date: 2013-12-5 下午8:16:44
 * 
 *         获取用户信息类
 * 
 */
public class DoubanUsersAPI extends DoubanService {

	public DoubanUsersAPI(String accessToken) {
		super(accessToken);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 获取登陆用户的信息
	 * 
	 * @param listener
	 * 
	 */
	public void getLoggedInUserProfile(RequestListener listener)
			throws DoubanException {

		String url = null;
		try {
			url = RequestUrls.DOUBAN_USER_V2_PREFIX
					+ URLEncoder.encode("/~me", "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request(url, null, HTTPMETHOD_GET, mAccessToken, listener);
	}

	/**
	 * 
	 * 获取指定用户的信息
	 * 
	 * @param uid
	 *            uid或者id
	 * @param listener
	 */
	public void getUserProfileByUid(String uid, RequestListener listener)
			throws DoubanException {

		String url = RequestUrls.DOUBAN_USER_V2_PREFIX + "/" + uid;
		request(url, null, HTTPMETHOD_GET, null, listener);
	}

	/**
	 * 
	 * 通过关键字查询用户
	 * 
	 * @param keyword
	 * @return
	 * @throws DoubanException
	 */
	public void searchUserProfile(String keyword, RequestListener listener)
			throws DoubanException {

		searchUserProfile(keyword, null, null, listener);
	}

	/**
	 * 获取指定数量的用户信息
	 * 
	 * @param keyword
	 * @param startIndex
	 * @param maxResultCount
	 * @param listener
	 * @throws DoubanException
	 */
	public void searchUserProfile(String keyword, Integer startIndex,
			Integer maxResultCount, RequestListener listener)
			throws DoubanException {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		if (keyword != null && keyword.length() > 0) {
			params.add(new BasicNameValuePair("q", keyword));
		} else {
			throw ErrorHandler.missingRequiredParam();
		}
		if (startIndex != null) {
			params.add(new BasicNameValuePair("start-index", startIndex
					.toString()));
		}
		if (maxResultCount != null) {
			params.add(new BasicNameValuePair("max-results", maxResultCount
					.toString()));
		}

		request(RequestUrls.DOUBAN_USER_V2_PREFIX, params, HTTPMETHOD_GET, null,
				listener);
	}
}
