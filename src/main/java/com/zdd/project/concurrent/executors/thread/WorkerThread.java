package com.zdd.project.concurrent.executors.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zhoudongdong<zdd109067> on 17/5/6.
 */
public class WorkerThread extends Thread {

  private String feature;
  private CountDownLatch latch;

  public WorkerThread(String feature) {
    this.feature = feature;
  }

  public WorkerThread(String feature, CountDownLatch latch) {
    this.feature = feature;
    this.latch = latch;
  }

  @Override
  public void run() {
    try {
      System.out.println(Thread.currentThread().getName() + " start. Name = " + feature);
      Thread.sleep(5000);
      System.out.println(Thread.currentThread().getName() + " end. Name = " + feature);

      if (latch != null) {
        latch.countDown();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public String getFeature() {
    return feature;
  }
}
