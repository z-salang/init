package com.zdd.project.concurrent.executors.handler;

import com.zdd.project.concurrent.executors.thread.WorkerThread;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by zhoudongdong<zdd109067> on 17/5/7.
 */
public class MyRejectedExecutionHandler implements RejectedExecutionHandler {

  private CountDownLatch latch;

  public MyRejectedExecutionHandler() {
    super();
  }

  public MyRejectedExecutionHandler(CountDownLatch latch) {
    this.latch = latch;
  }

  @Override
  public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
    WorkerThread worker = (WorkerThread) r;
    System.out.println(worker.getFeature() + " is rejected ..");

    if (latch != null) {
      latch.countDown();
    }
  }
}
