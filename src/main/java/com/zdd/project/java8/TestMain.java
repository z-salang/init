package com.zdd.project.java8;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/12/5 ??12:48
 */
public class TestMain {

    public static void main(String[] args) {
        Comparator<String> comp = (v1,v2) -> Integer.compare(v1.length(), v2.length());

        TestFunc testFunc = (a,b) -> a + b;
        int func = testFunc.func(1, 2);
        int add = testFunc.add(1, 2);

        System.out.println("add = " + add);
        System.out.println("func = " + func);

        String[] datas = new String[] {"aa", "bb"};
        Stream.of(datas).forEach(System.out::println);
        Stream.of(datas).forEach(PrintClass::print);
    }


    public static class PrintClass {
        public static void print(String string) {
            System.out.println("SSSSSS " + string);
        }
    }
}
