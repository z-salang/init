package com.zdd.project.Thread.async.to.sync;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/12/20 下午9:09
 */
public class Demo1 extends BaseDemo{
    private final Object lock = new Object();

    @Override
    public void callback(long response) {
        System.out.println("得到结果");
        System.out.println(response);
        System.out.println("调用结束");

        synchronized (lock) {
            lock.notifyAll();
        }

    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        demo1.call();

        synchronized (demo1.lock){
            try {
                demo1.lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("主线程内容");
    }
}
