package com.zdd.project.concurrent.CompletableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/3/13 ??11:29
 */
public class TestComposite {

    static List<Shop> shops = Arrays.asList(new Shop("sunjin.org"),
            new Shop("java jiiang"),
            new Shop("JD"),
            new Shop("TMALL"));

    public static void main(String[] args) throws Exception {
        List<CompletableFuture<Double>> futures = shops.stream().map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice("product")))
                .collect(toList());

        List<Double> doubleList1 = futures.stream().map(future -> {
            Double a = new Double(0);

            try {
                return future.get();
            } catch (InterruptedException e) {
                return a;
            } catch (ExecutionException e) {
                return a;
            }
        }).collect(toList());

        System.out.println(doubleList1);

        List<Double> doubleList2 = futures.stream().map(CompletableFuture::join).collect(Collectors.toList());
        System.out.println(doubleList2);
    }
}
