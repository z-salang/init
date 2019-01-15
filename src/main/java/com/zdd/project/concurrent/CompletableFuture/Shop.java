package com.zdd.project.concurrent.CompletableFuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/3/9 ??10:50
 */
public class Shop {
    private String name;
    private Random random = new Random();

    public Shop(String name) {
        this.name = name;
    }

    public double getPrice(String product){
        return calculatePrice(product);
    }

    public static void delay(){
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private double calculatePrice(String product){
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public Future<Double> getPriceAsync(String product){
        CompletableFuture<Double> future = new CompletableFuture<>();
        new Thread(() -> {
            double price = calculatePrice(product);
            future.complete(price);
        }).start();
        return future;
    }

    public Future<Double> getPriceAsync2(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void getException() throws Exception {
        throw new Exception("");
    }
}
