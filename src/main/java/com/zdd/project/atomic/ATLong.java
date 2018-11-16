package com.zdd.project.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/9/2 下午7:37
 */
public class ATLong {

  static ExecutorService threadPool = Executors.newFixedThreadPool(10);

  public static void main(String[] args) {
    final AtomicLong atomicLong = new AtomicLong(0);

    for (int i = 1; i <= 100; ++i) {
      threadPool.execute(new Runnable() {
        @Override
        public void run() {
          long l = atomicLong.get();
          System.out.println("Before : " + Thread.currentThread().getName() + " get " + l);
          //long l1 = atomicLong.addAndGet(1); // 返回值是set后的最新值
          long l1 = atomicLong.getAndAdd(1); // 返回值是set前的最新值
          System.out.println("After : " + Thread.currentThread().getName() + " get " + l1);
        }
      });
    }


  }
}
