package com.zdd.project.Thread.join.threadpool;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/9/1 下午3:44
 */
public class TestShutDown {

  static ExecutorService threadPool = Executors.newFixedThreadPool(3);

  static final CountDownLatch latch = new CountDownLatch(10);

  static Object lock = new Object();

  public static void main(String[] args) throws InterruptedException {

    for (int i = 1; i <= 10; ++i) {
      final int no = i;
      threadPool.execute(new Runnable() {
        @Override
        public void run() {
          try {
            taskRunner(no);
          } catch (InterruptedException e) {
            e.printStackTrace();
          } finally {
            latch.countDown();
          }
        }
      });
    }

    threadPool.shutdown();

    latch.await();
    //while (!threadPool.isTerminated()){
    //  System.out.println("waiting for tasks complete ..");
    //
    //  Thread.sleep(1000);
    //}

    System.out.println("Stop consumer ..");

  }

  static void taskRunner(int no) throws InterruptedException {
    System.out.println("Going to do task:" + no + " ..| THREAD-NAME: " + Thread.currentThread().getName());
    Thread.sleep(2000);
    System.out.println("Complete task " + no + " ..| THREAD-NAME: " + Thread.currentThread().getName());
  }

}
