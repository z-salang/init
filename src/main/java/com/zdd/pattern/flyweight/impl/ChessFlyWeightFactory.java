package com.zdd.pattern.flyweight.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/4/18 ??11:16
 */
public class ChessFlyWeightFactory {

    private static final ConcurrentMap<String, ChessFlyweight> map = new ConcurrentHashMap<>();

    public ChessFlyWeightFactory() {
    }

    public static ChessFlyweight get(String color) {
        if (map.size() > 0 && map.get(color) != null) {
            return map.get(color);
        } else {
            ChessFlyweight flyweight = new ChessFlyweight();
            flyweight.setColor(color);

            map.put(color, flyweight);
            return flyweight;
        }
    }
}
