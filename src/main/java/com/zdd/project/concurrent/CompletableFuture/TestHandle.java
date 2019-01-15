package com.zdd.project.concurrent.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2019/1/15 下午2:00
 */
public class TestHandle {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String name = null;
//        String name = "tony";

        CompletableFuture<String> future
                =  CompletableFuture.supplyAsync(() -> {
            if (name == null) {
                throw new RuntimeException("Computation error!");
            }
            return "Hello, " + name;
        }).handle((s, t) -> {
            if (s == null) {
                System.out.println("deal in async caught error :" + t);
                System.out.println("start to return an default value ...");
                return "DEFAULT_VALUE";
            }

            return s;
        });

        String s = future.get();
        System.out.println(s);
    }

}
