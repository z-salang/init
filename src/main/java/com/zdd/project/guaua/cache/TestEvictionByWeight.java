package com.zdd.project.guaua.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.Weigher;

import org.junit.Test;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2019/1/17 下午3:57
 */
public class TestEvictionByWeight {

    @Test
    public void eviction() {
        CacheLoader<String, String> loader = new CacheLoader<String, String>() {
            @Override
            public String load(String key) {
                return key.toUpperCase();
            }
        };

        Weigher<String, String> weigher = (key, value) -> {
            System.out.println(value + " " + value.length());
            return value.length();
        };

        LoadingCache<String, String> cache = CacheBuilder.newBuilder().maximumWeight(9).weigher(weigher).build(loader);

        cache.getUnchecked("first");
        cache.getUnchecked("second");
        cache.getUnchecked("third");
        cache.getUnchecked("last");

        System.out.println(cache.getIfPresent("first"));
        System.out.println(cache.getIfPresent("second"));
        System.out.println(cache.getIfPresent("third"));
        System.out.println(cache.getIfPresent("last"));
    }

}
