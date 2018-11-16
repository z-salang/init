package com.zdd.project.concurrent.executors.monitor;

import com.zdd.project.concurrent.executors.thread.WorkerThread;
import com.zdd.project.concurrent.executors.utils.ThreadUtils;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 17/5/7 00:43
 */
public class MyThreadMonitor extends Thread {

  private ThreadPoolExecutor executor;
  private int delaySecond;
  private boolean run = true;
  private LinkedBlockingDeque<Runnable> blockingDeque;

  public MyThreadMonitor(ThreadPoolExecutor executor, int delaySecond,
      LinkedBlockingDeque<Runnable> blockingDeque) {
    this.executor = executor;
    this.delaySecond = delaySecond;
    this.blockingDeque = blockingDeque;
  }

  public void shutdown() {
    this.run = false;
  }

  @Override
  public void run() {
    while (run) {
      String format =
          String.format(
              "[monitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s, deQueSize: %s",
              this.executor.getPoolSize(),
              this.executor.getCorePoolSize(),
              this.executor.getActiveCount(),
              this.executor.getCompletedTaskCount(),
              this.executor.getTaskCount(),
              this.executor.isShutdown(),
              this.executor.isTerminated(),
              this.blockingDeque.size());

      System.out.println(format);

      allWorkers(blockingDeque);

      ThreadUtils.toSleepMillis(delaySecond * 1000);
    }
  }

  private void allWorkers(LinkedBlockingDeque<Runnable> blockingDeque) {
    Iterator<Runnable> iterator = blockingDeque.iterator();
    while (iterator.hasNext()) {
      WorkerThread next = (WorkerThread) iterator.next();
      System.out.println(next.getFeature() + " is in the BlockingDeque .." );
    }
  }
}
