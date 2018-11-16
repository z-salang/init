package com.zdd.project.utils;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/11/28 ??3:06
 */
public class TestMain {

    public static void main(String[] args) throws ParseException {
        //new Thread(() -> {
        //    System.out.println("aaaaaa");
        //}).start();
        //
        //ThreadLocal<Long> local = ThreadLocal.withInitial(() -> 1L);
        //
        List features = Arrays.asList("Lambdas", "Default Method",
            "Stream API", "Date and Time API");

        List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");


        //filter(features, (str)->str);

        //filter(languages, (str) ->str.endsWith("A"));

        //Stream lengths = names.stream().map(name -> check(name));
    }

    public static void filter(List names, Predicate condition) {
        names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {
                System.out.println(name + " ");
            });
    }
}
