package com.zdd.project.reflect.impl;

import com.zdd.project.reflect.INoHello;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/5/27 下午2:53
 */
public class NoHello implements INoHello {
  @Override
  public void sayWhatTheFuck() {
    System.out.println("What the fuck ..");
  }
}
