package com.zdd.project.collection.map;

import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/3/9 ??4:06
 */
public class TestConcurrentNavigableMap {

    public static void main(String[] args) {
        ConcurrentNavigableMap<Long, String> navigableMap = new ConcurrentSkipListMap<>();

        navigableMap.put(11L, "AA");
        navigableMap.put(11L, "BB");
        navigableMap.put(22L, "cc");

        System.out.println(navigableMap);


        long longKey1 = 112;
        long longKey2 = 112;

        System.out.println(longKey1 > longKey2 ? 1 : (longKey1 == longKey2 ? 0 : -1));

    }
}
