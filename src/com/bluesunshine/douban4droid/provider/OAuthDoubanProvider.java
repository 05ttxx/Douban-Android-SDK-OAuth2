package com.bluesunshine.douban4droid.provider;

import java.util.ArrayList;
import java.util.List;

import com.bluesunshine.douban4droid.constants.DefaultConfigs;
import com.bluesunshine.douban4droid.model.app.RequestGrantScope;
import com.bluesunshine.douban4droid.utils.Debugs;

/**
 * 
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 * 
 *         用于Oauth认证 Modified by hao.wen 2013-12-5
 */
public class OAuthDoubanProvider {

	private String apiKey = DefaultConfigs.API_KEY;
	private String secretKey = DefaultConfigs.SECRET_KEY;
	private String authUrl = DefaultConfigs.AUTH_URL;
	private String redirectUrl = DefaultConfigs.ACCESS_TOKEN_REDIRECT_URL;
	private String responseType = "code";
	private String grantType = "authorization_code";

	private List<RequestGrantScope> scopes = new ArrayList<RequestGrantScope>();

	/**
	 * @return the apiKey
	 */
	public String getApiKey() {
		return apiKey;
	}

	/**
	 * @param apiKey
	 *            the apiKey to set
	 */
	public OAuthDoubanProvider setApiKey(String apiKey) {
		this.apiKey = apiKey;
		return this;
	}

	/**
	 * @return the secretKey
	 */
	public String getSecretKey() {
		return secretKey;
	}

	/**
	 * @param secretKey
	 *            the secretKey to set
	 */
	public OAuthDoubanProvider setSecretKey(String secretKey) {
		this.secretKey = secretKey;
		return this;
	}

	/**
	 * @return the authUrl
	 */
	public String getAuthUrl() {
		return authUrl;
	}

	/**
	 * @param authUrl
	 *            the authUrl to set
	 */
	public OAuthDoubanProvider setAuthUrl(String authUrl) {
		this.authUrl = authUrl;
		return this;
	}

	/**
	 * @return the redirectUrl
	 */
	public String getRedirectUrl() {
		return redirectUrl;
	}

	/**
	 * @param redirectUrl
	 *            the redirectUrl to set
	 */
	public OAuthDoubanProvider setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
		return this;
	}

	/**
	 * @return the type
	 */
	public String getResponseType() {
		return responseType;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public OAuthDoubanProvider setResponseType(String type) {
		this.responseType = type;
		return this;
	}

	/**
	 * @return the grantType
	 */
	public String getGrantType() {
		return grantType;
	}

	/**
	 * @param grantType
	 *            the grantType to set
	 */
	public OAuthDoubanProvider setGrantType(String grantType) {
		this.grantType = grantType;
		return this;
	}

	/**
	 * 增加豆瓣申请权限
	 * 
	 * @param scope
	 * @return
	 */
	public OAuthDoubanProvider addScope(RequestGrantScope scope) {
		this.scopes.add(scope);
		return this;
	}
	
	/**
	 * 
	 * 用于获取请求Token的URL
	 * 
	 * @return
	 */
	public String getGetCodeRedirectUrl() {
		if (this.redirectUrl == null || this.redirectUrl.isEmpty()) {
			Debugs.d("wenhao",
					"Redirect url cannot be null or empty, did you forget to set it?");
			return null;
		}
		StringBuilder getCodeUrl = new StringBuilder(this.authUrl);
		getCodeUrl.append("?client_id=").append(this.apiKey)
				.append("&redirect_uri=").append(this.redirectUrl)
				.append("&response_type=").append(this.responseType);
		if (!this.scopes.isEmpty()) {
			getCodeUrl.append("&scope=").append(generateScopeString());
		}
		return getCodeUrl.toString();
	}

	/**
	 * 
	 * 生成请求豆瓣权限的字符串
	 * 
	 * @return
	 */
	private String generateScopeString() {
		if (this.scopes == null || this.scopes.isEmpty()) {
			return "";
		} else {
			StringBuilder scopeStr = new StringBuilder();
			for (RequestGrantScope sco : this.scopes) {
				scopeStr.append(sco.getValue()).append(",");
			}
			scopeStr.deleteCharAt(scopeStr.length() - 1); // Get rid of the last
															// comma
			return scopeStr.toString();
		}
	}

}
