package com.dongxuexidu.douban4j.utils;

import java.io.IOException;

import com.dongxuexidu.douban4j.model.app.DoubanException;

/**
 * 
 * @author hao.wen <wenhao7704@gmail.com>
 * 
 */
public interface RequestListener {
	/**
	 * 用于获取服务器返回的响应内容
	 * 
	 * @param response
	 */
	public void onComplete(String response);

	public void onIOException(IOException e);

	public void onError(DoubanException e);

}
