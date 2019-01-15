package com.zdd.project.concurrent.CompletableFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/3/9 ??10:52
 */
public class Client {
    public static void main(String[] args){
        Shop shop = new Shop("BestShop");
        long start = System.currentTimeMillis();
        Future<Double> future = shop.getPriceAsync("My Favorite");
        long invocationTime = System.currentTimeMillis() - start;
        System.out.println("Call RPC cost : " + invocationTime + "millis");

        doSomethingElse();

        try {
            double price = future.get();
            System.out.println("get Price "+ price);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        long retrievalTime = System.currentTimeMillis() - start;
        System.out.println("all cost after price returned : " + retrievalTime + "millis");


        try {
            Future<Double> future1 = shop.getPriceAsync2("My Favorite");
            System.out.println("get Price "+ future1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public static void doSomethingElse(){
        System.out.println("do sth else ..");
    }


}
