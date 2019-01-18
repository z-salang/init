package com.zdd.project.guaua.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

import com.zdd.project.concurrent.executors.utils.ThreadUtils;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2019/1/18 上午10:07
 */
public class TestRefresh {

    @Test
    public void testRefresh() {
        CacheLoader<String, String> loader = new CacheLoader<String, String>() {
            @Override
            public String load(String key) {
                return key.toUpperCase();
            }

            @Override
            public ListenableFuture<String> reload(String key, String oldValue) {
                System.out.println("start to reload by key " + key + ", oldValue " + oldValue);
                return Futures.immediateFuture("new-" + oldValue);
            }
        };

        LoadingCache<String, String> cache = CacheBuilder.newBuilder().maximumSize(10).refreshAfterWrite(2, TimeUnit.SECONDS).build(loader);

        cache.getUnchecked("first");
        cache.getUnchecked("second");

        System.out.println(cache.getIfPresent("first"));
        System.out.println(cache.getIfPresent("second"));

        ThreadUtils.toSleepMillis(4 * 1000);

        System.out.println(cache.getIfPresent("first"));
        System.out.println(cache.getIfPresent("second"));
    }
}
