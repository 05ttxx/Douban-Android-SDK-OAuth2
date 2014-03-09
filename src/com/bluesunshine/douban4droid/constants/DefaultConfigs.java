package com.bluesunshine.douban4droid.constants;

import com.google.api.client.xml.XmlNamespaceDictionary;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DefaultConfigs {
  
	/**
	 * 
	 * 将在douban应用当中申请的密钥填写在此处
	 * 
	 * */
	public static final String API_KEY = "0ff5c33d5ff4b2f32fe149b81fde18d9";
	public static final String SECRET_KEY = "da958344cab0eaf5";
	public static final String ACCESS_TOKEN_REDIRECT_URL = "http://leochin.com/";
  
  public static final String API_URL_PREFIX = "https://api.douban.com";
  public static final String AUTH_URL = "https://www.douban.com/service/auth2/auth";
  public static final String ACCESS_TOKEN_URL = "https://www.douban.com/service/auth2/token";

  
  
  public static final XmlNamespaceDictionary DOUBAN_XML_NAMESPACE = new XmlNamespaceDictionary()
          .set("", "http://www.w3.org/2005/Atom")
          .set("db", "http://www.douban.com/xmlns/")
          .set("gd", "http://schemas.google.com/g/2005")
          .set("opensearch", "http://a9.com/-/spec/opensearchrss/1.0/");
  
}
