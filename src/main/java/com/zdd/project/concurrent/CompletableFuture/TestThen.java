package com.zdd.project.concurrent.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2019/1/14 下午6:50
 */
public class TestThen {

    public static void main(String[] args) {
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<Void> future = completableFuture.thenApply(s -> s + " world")
                .thenAccept(s -> System.out.println("Computation returned: " + s))
                .thenRun(() -> System.out.println(" ======= end ========"))
                .thenRun(() -> System.out.println(" ======= end again ========"));

        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
