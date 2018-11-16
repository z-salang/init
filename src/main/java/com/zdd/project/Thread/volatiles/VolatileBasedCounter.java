package com.zdd.project.Thread.volatiles;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/11/26 ??2:52
 */
public class VolatileBasedCounter {
  private volatile int value;

  public int getValue() {
    return value;
  }

  public synchronized int increament() {
    return this.value++;
  }

  public static void main(String[] args) {
    final VolatileBasedCounter counter = new VolatileBasedCounter();

    for (int i = 0; i < 30; i++) {
      new Thread(new Runnable() {
        @Override
        public void run() {
          System.out.println("Get" + counter.getValue() + " _ " + Thread.currentThread().getName());
          counter.increament();
        }
      }).start();
    }

    System.out.println("Get" + counter.getValue() + " _ " + Thread.currentThread().getName());
  }
}
