package com.dongxuexidu.douban4j.service;

import com.dongxuexidu.douban4j.model.app.DoubanException;
import com.dongxuexidu.douban4j.utils.ErrorHandler;
import com.dongxuexidu.douban4j.utils.HttpManager3;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public abstract class DoubanService {
  
  protected HttpManager3 client = null;
  
  protected DoubanService () {
    this.client = new HttpManager3();
  }
  
  protected DoubanService (String accessToken) {
    this.client = new HttpManager3(accessToken);
  }
  
  protected void setAccessToken (String accessToken) throws DoubanException {
    if (accessToken == null || accessToken.isEmpty()) {
      throw ErrorHandler.accessTokenNotSet();
    }
    this.client.setAccessToken(accessToken);
  }
  
}
