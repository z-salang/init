package com.zdd.project.guaua.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import org.junit.Test;

import java.util.Optional;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2019/1/17 下午7:18
 */
public class TestNull {

    @Test
    public void testNull() {
        CacheLoader<Integer, Optional<String>> cacheLoader = new CacheLoader<Integer, Optional<String>>() {
            @Override
            public Optional<String> load(Integer key) {
                if (key == 3) {
                    return Optional.empty();
                }

                return Optional.of(key + "-value");
            }
        };

        LoadingCache<Integer, Optional<String>> cache = CacheBuilder.newBuilder().maximumSize(10).build(cacheLoader);

        System.out.println(cache.getUnchecked(1).isPresent());
        System.out.println(cache.getUnchecked(2).isPresent());
        System.out.println(cache.getUnchecked(3).isPresent());
        System.out.println(cache.getUnchecked(4).isPresent());
        System.out.println(cache.getUnchecked(5).isPresent());

    }
}
