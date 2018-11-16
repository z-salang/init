package com.zdd.project.Thread.numbers;

import java.util.concurrent.CountDownLatch;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/11/22 下午4:38
 */
public class HoldThread extends Thread {
  private CountDownLatch latch = new CountDownLatch(1);

  public HoldThread() {
    this.setDaemon(true);
  }

  @Override
  public void run() {
    try {
      latch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
