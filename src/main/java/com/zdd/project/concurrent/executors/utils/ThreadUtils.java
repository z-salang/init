package com.zdd.project.concurrent.executors.utils;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 17/5/7 00:52
 */
public class ThreadUtils {

  public static void toSleepMillis(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      System.out.println("Thread Sleep was interrupted .., e:" + e);
    }
  }
}
