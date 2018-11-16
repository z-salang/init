package com.zdd.project.Thread;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/12/10 ??1:55
 */
public class MyThreadClass extends Thread {

    @Override
    public void run() {
        int i = 1;

        while (i <= 10) {
            System.out.println("i= " + i);
            ++i;
        }
    }

    public static void main(String[] args) {
        MyThreadClass threadClass = new MyThreadClass();
        threadClass.start();
    }
}
