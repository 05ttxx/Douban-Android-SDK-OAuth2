package com.bluesunshine.douban4droid.api;

import com.bluesunshine.douban4droid.constants.RequestUrls;
import com.bluesunshine.douban4droid.utils.RequestListener;

/**
 * 
 * 获取图书、电影、音乐相关信息
 * 
 * @author hao.wen <wenhao7704@gmail.com> date: 2013-12-6 下午5:49:33
 * 
 */
public class DoubanBookAPI extends DoubanService {

	public DoubanBookAPI(String accessToken) {
		super(accessToken);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * 通过图书id获取图书信息
	 * 
	 * @param bookId
	 * @param listener
	 */
	public void getBookInfoById(long bookId, RequestListener listener){
		
		String url = RequestUrls.DOUBAN_BOOK_V2_PREFIX + "/" + bookId;		
		request(url, null, HTTPMETHOD_GET, null, listener);	
	}
	
	/**
	 * 
	 * 通过isbn获取图书信息
	 * 
	 * @param isbn
	 * @param listener
	 */
	public void getBookInfoByISBN (String isbn, RequestListener listener) {
		
		String url = RequestUrls.DOUBAN_BOOK_V2_PREFIX + "/isbn/" + isbn;
		request(url, null, HTTPMETHOD_GET, null, listener);		
	}

}
