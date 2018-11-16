package com.zdd.project.Thread.exception;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/4/7 ??2:10
 */
public class SubThread implements Runnable {

    @Override
    public void run() {
        System.out.println("InnerRunnable - " + Thread.currentThread().getName());
        throw new RuntimeException("exception occurred in SubThread");
    }
}
