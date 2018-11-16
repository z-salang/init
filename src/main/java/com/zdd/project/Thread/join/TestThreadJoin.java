package com.zdd.project.Thread.join;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/7/30 下午7:19
 */
public class TestThreadJoin {

  public static void main(String[] args) throws InterruptedException {
    Thread t = new Thread(new MyThread());
    long startTime = System.currentTimeMillis();
    t.start();

    t.join(10);
    System.out.println("主线程等待 Join 线程结束");

    System.out.println(System.currentTimeMillis() - startTime);
    System.out.println("Main thread finished ..");
  }


}
