package com.zdd.project.Thread.join;

import static java.lang.Thread.sleep;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/11/22 下午2:28
 */
public class MyThread implements Runnable {
  @Override
  public void run() {
    //synchronized (currentThread()) {
      for (int i = 1; i <= 5; i++) {
        try {
          sleep(1000);//睡眠5秒，循环是为了方便输出信息
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("睡眠" + i);
      }
      System.out.println("TestJoin finished");//t线程结束
    }
  //}
}
