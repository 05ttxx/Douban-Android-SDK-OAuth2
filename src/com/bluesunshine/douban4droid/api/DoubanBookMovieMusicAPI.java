package com.bluesunshine.douban4droid.api;

import java.io.IOException;

import com.bluesunshine.douban4droid.constants.RequestUrls;
import com.bluesunshine.douban4droid.model.app.DoubanException;
import com.bluesunshine.douban4droid.utils.RequestListener;

/**
 * 
 * 获取图书、电影、音乐相关信息
 * 
 * @author hao.wen <wenhao7704@gmail.com> date: 2013-12-6 下午5:49:33
 * 
 */
public class DoubanBookMovieMusicAPI extends DoubanService {

	protected DoubanBookMovieMusicAPI(String accessToken) {
		super(accessToken);
		// TODO Auto-generated constructor stub
	}

	public void getBookInfoById(long bookId,RequestListener listener)
			throws DoubanException, IOException {
		
		String url = RequestUrls.DOUBAN_BOOK_SUBJECT_PREFIX + "/" + bookId;		
//		DoubanSubjectObj book = this.client.getResponse(url, null,
//				DoubanSubjectObj.class, false);		
		request(url, null, HTTPMETHOD_GET, null, listener);
		
	}

}
