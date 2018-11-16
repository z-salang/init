package com.zdd.project.concurrent.CompletableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/3/9 ??11:00
 */
public class TestMain {

    public static void main(String[] args) throws Exception {
        test1();
    }


    public static void test1() throws Exception {

        CompletableFuture<String> completableFuture = new CompletableFuture();
        try {
            new Thread(() -> {
                System.out.println("task doing...");
                try {
                    getExFunc();
//                } catch (Exception e) {  // ?????? ????completableFuture.get()??????
//
//                }
                } finally {
                    completableFuture.complete("result");
                }
            }).start();

        } catch (Exception e) {
            System.out.println("get error when doing task ..");
        }

        String result = completableFuture.get();
        System.out.println("result : " + result);

    }

    private static void getExFunc() {
        throw new RuntimeException("error error error error ..");
    }
}
