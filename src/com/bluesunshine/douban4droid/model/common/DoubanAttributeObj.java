/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bluesunshine.douban4droid.model.common;

import com.bluesunshine.douban4droid.model.IDoubanObject;
import com.google.api.client.util.Key;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanAttributeObj implements IDoubanObject {

  @Override
  public String getObjName() {
    return "attribute";
  }
  
  @Key ("@name")
  private String name;
  
  @Key ("text()")
  private String value;

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the value
   */
  public String getValue() {
    return value;
  }

  /**
   * @param value the value to set
   */
  public void setValue(String value) {
    this.value = value;
  }
  
}
