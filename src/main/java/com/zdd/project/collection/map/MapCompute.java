package com.zdd.project.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/5/9 ??11:49
 */
public class MapCompute {
    static Map<String, String> map = new HashMap<>();
    static Map<String, Map<Integer, String>> cMap = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {

        String key = "aaa";
        String value = " + ";

        compute(key, value);
        System.out.println(map);
        compute(key, value);
        System.out.println(map);
        compute(key, value);
        System.out.println(map);

        String aKey = "aKey";
        int intValue1 = 1;
        int intValue2 = 2;
        String strValue1 = " +1 ";
        String strValue2 = " +2 ";

        System.out.println();

        compute(aKey, intValue1, strValue1);
        System.out.println(cMap);

        compute(aKey, intValue2, strValue2);
        System.out.println(cMap);
    }

    private static void compute(String key, int intValue, String strValue) {
        cMap.compute(key, (k, old) -> {

            if (old == null) {
                old = new HashMap<>();
            }

            old.put(intValue, strValue);

            return old;
        });
    }

    private static void compute(String key, String value) {
        map.compute(key, (k, old) -> {
            if (old == null) {
                return value;
            }

            return old + value;
        });
    }
}
