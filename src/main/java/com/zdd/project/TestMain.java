package com.zdd.project;

import com.zdd.project.reflect.basic.getter.Child;
import com.zdd.project.reflect.basic.getter.Father;
import com.zdd.project.reflect.basic.getter.Human;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/12/5 ??7:30
 */
public class TestMain {

    public static Map<Class<? extends Human>, List<Human>> mapList = new HashMap<>();

    public static void main(String[] args) throws IOException {

        Map<String, String> map = new HashMap<>();

        map.computeIfAbsent("aaa", k -> getValue());
        System.out.println(map);
        map.computeIfAbsent("aaa", k -> getValue(k));
        System.out.println(map);

        Human h1 = new Father();
        Human h2 = new Father();
        Human h3 = new Father();

        Human h4 = new Child();
        Human h5 = new Child();

        addMap(h1);
        addMap(h2);
        addMap(h3);
        addMap(h4);
        addMap(h5);


        System.out.println(mapList.get(h1.getClass()));
        System.out.println(mapList.get(h4.getClass()));

    }

    public static void addMap(Human human) {
        mapList.computeIfAbsent(human.getClass(), k -> new ArrayList<>()).add(human);
    }

    static HashSet<String> getHashSet() {
        return new HashSet<>();
    }

    static String getValue() {
        return "===";
    }

    static String getValue(String n) {
        return n + "===";
    }

}