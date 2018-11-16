package com.zdd.project.java8;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/12/5 ??12:47
 */
public interface TestFunc<T> {

    default int func(int a, int b) throws RuntimeException {
        return a + b;
    }

    int add(int a, int b);

    default String getStr(String str) {
        return "signature" + str;
    }

}
