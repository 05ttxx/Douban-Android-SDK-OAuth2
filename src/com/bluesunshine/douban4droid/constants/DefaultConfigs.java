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
  public static final String API_KEY = "066f4faf6ceca862134def0e46c5f926";
  public static final String SECRET_KEY = "14f5e0a656d3056a";
  public static final String ACCESS_TOKEN_REDIRECT_URL = "http://hnrainll.cnblogs.com/";
  
  public static final String API_URL_PREFIX = "https://api.douban.com";
  public static final String AUTH_URL = "https://www.douban.com/service/auth2/auth";
  public static final String ACCESS_TOKEN_URL = "https://www.douban.com/service/auth2/token";

  
  
  public static final XmlNamespaceDictionary DOUBAN_XML_NAMESPACE = new XmlNamespaceDictionary()
          .set("", "http://www.w3.org/2005/Atom")
          .set("db", "http://www.douban.com/xmlns/")
          .set("gd", "http://schemas.google.com/g/2005")
          .set("opensearch", "http://a9.com/-/spec/opensearchrss/1.0/");
  
}
