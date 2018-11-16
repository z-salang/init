package com.zdd.project.concurrent.executors;

import com.zdd.project.concurrent.executors.thread.WorkerThread;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhoudongdong<zdd109067> on 17/5/6.
 */
public class TestExecutorServiceSimply {

  public static void main(String[] args) {
    int workerNum = 10;
    CountDownLatch latch = new CountDownLatch(workerNum);
    ExecutorService executorService = Executors.newFixedThreadPool(5);

    for (int i = 0; i < workerNum; ++i) {
      executorService.execute(new WorkerThread("feature--" + i, latch));
    }

    executorService.shutdown();

    try {
      latch.wait();
    } catch (InterruptedException e) {
      System.out.println(e);
    }

    System.out.println("Finished all threads ..");
  }
}
