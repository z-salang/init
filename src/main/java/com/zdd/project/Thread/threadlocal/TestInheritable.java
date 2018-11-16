package com.zdd.project.Thread.threadlocal;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/11/22 下午2:38
 */
public class TestInheritable {
  static final InheritableThreadLocal<Integer> inheritableCtx = new InheritableThreadLocal<>();
  static final ThreadLocal<Integer> ctx = new ThreadLocal<>();

  public static void main(String[] args) {
    inheritableCtx.set(123);
    ctx.set(321);

    new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("Get from inheritable : " + inheritableCtx.get());
        System.out.println("Get from  ctx : " + ctx.get());

        inheritableCtx.set(1285);
        ctx.set(8521);
      }
    }).start();

    System.out.println("Main get from inheritable : " + inheritableCtx.get());
    System.out.println("Main get from ctx : " + ctx.get());

  }
}
