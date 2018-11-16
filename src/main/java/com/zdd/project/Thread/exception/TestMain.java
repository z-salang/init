package com.zdd.project.Thread.exception;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/4/7 ??2:10
 */
public class TestMain {

    public static void main(String[] args) {
        System.out.println("Main - " + Thread.currentThread().getName());
//        catchThreadException0();
        catchThreadException1();
//        catchThreadException2();
//        catchThreadException3();
//        catchThreadException4();

    }

    static void catchThreadException4() {
        try {
            new SubThread().run();
        } catch (Exception e) {
            System.out.println("caught exception in outer thread " + e);
        }
    }

    static void catchThreadException3() {
        try {

            new Thread(() -> {
                throw new RuntimeException();
            }).start();
        } catch (Exception e) {
            System.out.println("caught exception in outer thread " + e);
        }
    }

    static void catchThreadException2() {
        try {

            new Thread(() -> {

                new SubThread().run();

            }).start();

        } catch (Exception e) {
            System.out.println("caught exception in outer thread " + e);
        }
    }

    static void catchThreadException1() {
        try {

            new Thread(() -> {
                try {
                    new SubThread().run();
                } catch (Exception e) {
                    System.out.println("caught exception in inner thread " + Thread.currentThread().getName());
                    throw new RuntimeException(e);
                }

            }).start();
        } catch (Exception e) {
            System.out.println("caught exception in outer thread " + e + " " + Thread.currentThread().getName());
        }
    }

    static void catchThreadException0() {
        try {
            ((Runnable) () -> {

                System.out.println("OuterRunnable - " + Thread.currentThread().getName());

                try {
                    new SubThread().run();
                } catch (Exception e) {
                    System.out.println("caught exception in inner thread");
                    throw new RuntimeException(e);
                }
            }).run();

        } catch (Exception e) {
            System.out.println("caught exception in outer thread " + e);
        }
    }

}
