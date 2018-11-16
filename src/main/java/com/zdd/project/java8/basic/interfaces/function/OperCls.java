package com.zdd.project.java8.basic.interfaces.function;

import java.util.function.Function;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/1/25 ??10:49
 */
public class OperCls {

    public static final int addOne(int a) {
        return a + 1;
    }

    public static final int oper(int a, Function<Integer, Integer> function) {
        return function.apply(a);
    }

    public static final int after(int a, Function<Integer, Integer> function) {
        return addOne(function.apply(a));
    }

}
