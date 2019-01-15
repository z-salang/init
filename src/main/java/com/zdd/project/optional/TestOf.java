package com.zdd.project.optional;

import java.util.Optional;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2019/1/14 下午7:39
 */
public class TestOf {


    public static void main(String[] args) {
        Optional<String> test = Optional.of("test");
        System.out.println(test.get());
        System.out.println(test.map(String::toUpperCase).get());


        Optional<Optional<String>> complexTest = Optional.of(Optional.of("complex test"));
        Optional<String> optional = complexTest.get();

    }
}
