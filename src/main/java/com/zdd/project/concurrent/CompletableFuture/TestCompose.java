package com.zdd.project.concurrent.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2019/1/14 下午7:16
 */
public class TestCompose {

    public static void main(String[] args) {
        TestCompose compose = new TestCompose();
        compose.compose1();
        compose.compose2();

    }

    private void compose2() {
        CompletableFuture future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenAcceptBoth(CompletableFuture.supplyAsync(() -> " World"),
                        (s1, s2) -> System.out.println(s1 + s2));

        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private void compose1() {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> "hello ")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + "world"))
                .thenAccept(s -> System.out.println(s));

        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
