package com.bluesunshine.douban4droid.api;

import com.bluesunshine.douban4droid.constants.RequestUrls;
import com.bluesunshine.douban4droid.utils.RequestListener;


/**
 * 
 * 
 * @author wenhao  <wenhao@leochin.com>
 * 
 * Mar 10, 2014  11:29:41 PM
 * 
 * http://developers.douban.com/wiki/?title=movie_v2
 *
 */
public class DoubanMovieAPI extends DoubanService {

	public DoubanMovieAPI(String accessToken) {
		super(accessToken);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * 通过id查询movie信息
	 * 
	 * @param movieId
	 * @param listener
	 */
	public void getMovieInfoById(long movieId, RequestListener listener) {
		
		String url = RequestUrls.DOUBAN_MOVIE_V2_SUBJECT_PREFIX + "/" + movieId;
		request(url, null, HTTPMETHOD_GET, null, listener);	
	}
	
	/**
	 * 
	 * 豆瓣top250
	 * 
	 * @param start
	 * @param count
	 * @param listener
	 */
	public void getMoviesTop250(int start, int count, RequestListener listener) {
		
		String url = RequestUrls.DOUBAN_MOVIE_V2_PREFIX + "/" + "top250?count=" + count;		
		request(url, null, HTTPMETHOD_GET, null, listener);	   
	}
	
	/**
	 * 影人条目信息
	 * 
	 * /v2/movie/celebrity/:id
	 * 
	 * GET /v2/movie/celebrity/1054395
	 */
	
	/**
	 * 
	 * 电影条目搜索
	 * 
	 * /v2/movie/search?q={text}
	 * 
	 * GET /v2/movie/search?q=张艺谋 GET /v2/movie/search?tag=喜剧
	 * 
	 */

}
