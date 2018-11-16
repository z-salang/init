package com.zdd.project.reflect.classs;

import java.lang.reflect.Field;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/5/27 下午3:25
 */
public class Clz {

  private String str;

  public void func() {
    try {
      Field field = Clz.class.getDeclaredField("str");
      System.out.println(field);
    } catch (NoSuchFieldException e) {
      e.printStackTrace();
    }
  }
}
