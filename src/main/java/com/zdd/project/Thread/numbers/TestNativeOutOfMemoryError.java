package com.zdd.project.Thread.numbers;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/11/22 下午4:40
 */
public class TestNativeOutOfMemoryError {

  public static void main(String[] args) {
    for (int i=0; ; ++i) {
      System.out.println("Start to create No " + i );
      new HoldThread().start();
    }
  }
}
