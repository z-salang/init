package com.zdd.project.ending;

import sun.misc.Unsafe;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/5/27 上午10:51
 */
public class TestMain {

  private static final Unsafe UNSAFE = Unsafe.getUnsafe();

  public static void main(String[] args) {
    BigOrSmallEnding.func(UNSAFE);
  }
}
