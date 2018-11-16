package com.zdd.project.concurrent.CompletableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.util.stream.Collectors.toList;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/3/9 ??11:08
 */
public class CompletableFutureTest {

    static List<Shop> shops = Arrays.asList(new Shop("sunjin.org"),
            new Shop("java jiiang"),
            new Shop("JD"),
            new Shop("TMALL"));


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(findPrice("java8"));
        long duration = System.currentTimeMillis() - start;
        System.out.println("total cost : " + duration + "millis");
    }

    public static List<String> findPrice(String product) {

        return shops.parallelStream()
                .map(shop -> String.format("%s's price is %.2f", shop.getName(), shop.getPrice(product)))
                .collect(toList());

    }

    public static List<String> findPrice2(String product) {
        List<CompletableFuture<String>> priceFuture = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> shop.getName() + " 's price is" + shop.getPrice(product)))
                .collect(toList());

        return priceFuture.stream()
                .map(CompletableFuture::join)
                .collect(toList());
    }

}
