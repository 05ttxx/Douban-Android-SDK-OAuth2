package com.dongxuexidu.douban4j.constants;

/**
 * 
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class RequestUrls {
	
	/**
	 * 
	 * (useless)
	 * 
	 * @author hao.wen <wenhao7704@gmail.com>
	 */
	public static final String DOUBAN_USER_PREFIX = DefaultConfigs.API_URL_PREFIX
			+ "/user";

	/**
	 * User services
	 * 
	 * @author hao.wen <wenhao7704@gmail.com> Modified by hao.wen 2013-12-4
	 *         修改为Oauth2的接口
	 */
	public static final String DOUBAN_USER_V2_PREFIX = DefaultConfigs.API_URL_PREFIX
			+ "/v2/user";

	/**
	 * Collection services
	 */
	public static final String DOUBAN_COLLECTION_PREFIX = DefaultConfigs.API_URL_PREFIX
			+ "/collection";

	/**
	 * Review services
	 */
	public static final String DOUBAN_REVIEW_PREFIX = DefaultConfigs.API_URL_PREFIX
			+ "/review";

	/**
	 * Subject services
	 */
	public static final String DOUBAN_BOOK_SUBJECT_PREFIX = DefaultConfigs.API_URL_PREFIX
			+ "/book/subject";
	public static final String DOUBAN_MOVIE_SUBJECT_PREFIX = DefaultConfigs.API_URL_PREFIX
			+ "/movie/subject";
	public static final String DOUBAN_MUSIC_SUBJECT_PREFIX = DefaultConfigs.API_URL_PREFIX
			+ "/music/subject";

	public static final String DOUBAN_MOVIE_V2_SUBJECT_PREFIX = DefaultConfigs.API_URL_PREFIX
			+ "/v2/movie/subject";

	public static final String DOUBAN_MOVIE_V2_PREFIX = DefaultConfigs.API_URL_PREFIX
			+ "/v2/movie";

	/**
	 * Note services
	 */
	public static final String DOUBAN_NOTE_PREFIX = DefaultConfigs.API_URL_PREFIX
			+ "/note";

	/**
	 * Doumail Services
	 */

	public static final String DOUBAN_MAIL_PREFIX = DefaultConfigs.API_URL_PREFIX
			+ "/doumail";

	/**
	 * Event Services
	 */

	public static final String DOUBAN_EVENT_PREFIX = DefaultConfigs.API_URL_PREFIX
			+ "/event";

	/**
	 * Douban shuo Services
	 */

	public static final String DOUBAN_SHUO_STATUS_PREFIX = DefaultConfigs.API_URL_PREFIX
			+ "/shuo/statuses";

	public static final String DOUBAN_SHUO_USER_PREFIX = DefaultConfigs.API_URL_PREFIX
			+ "/shuo/users";

	public static final String DOUBAN_SHUO_FRIENDSHIP_PREFIX = DefaultConfigs.API_URL_PREFIX
			+ "/shuo/friendships";

}
