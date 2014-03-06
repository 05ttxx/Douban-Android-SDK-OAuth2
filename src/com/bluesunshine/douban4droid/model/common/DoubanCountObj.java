package com.bluesunshine.douban4droid.model.common;

import com.bluesunshine.douban4droid.model.IDoubanObject;
import com.google.api.client.util.Key;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanCountObj implements IDoubanObject{

  @Override
  public String getObjName() {
    return "doubancommentscount";
  }
  
  @Key("@value")
  private int value;

  /**
   * @return the value
   */
  public int getValue() {
    return value;
  }

  /**
   * @param value the value to set
   */
  public void setValue(int value) {
    this.value = value;
  }
  
}
