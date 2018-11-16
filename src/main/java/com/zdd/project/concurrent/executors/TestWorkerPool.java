package com.zdd.project.concurrent.executors;

import com.zdd.project.concurrent.executors.handler.MyRejectedExecutionHandler;
import com.zdd.project.concurrent.executors.monitor.MyThreadMonitor;
import com.zdd.project.concurrent.executors.thread.WorkerThread;
import com.zdd.project.concurrent.executors.utils.ThreadUtils;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 线程池测试类
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 17/5/7 00:56
 */
public class TestWorkerPool {

  public static void main(String[] args) {
    RejectedExecutionHandler rejectedHandler = new MyRejectedExecutionHandler();
    LinkedBlockingDeque<Runnable> blockingDeque = new LinkedBlockingDeque<>(3);

    // If used rejectedHandler, some request will be deal with its method HiveChargeLogService();
    ThreadPoolExecutor executorPool = new ThreadPoolExecutor(2, 5, 10, TimeUnit.SECONDS, blockingDeque, rejectedHandler);

    MyThreadMonitor monitor = new MyThreadMonitor(executorPool, 3, blockingDeque);
    monitor.start();

    for (int i = 0; i < 10; ++i) {
      executorPool.execute(new WorkerThread("Worker--" + i));
    }

    ThreadUtils.toSleepMillis(30 * 1000);

    executorPool.shutdown();

    ThreadUtils.toSleepMillis(5000);
    monitor.shutdown();
  }
}
