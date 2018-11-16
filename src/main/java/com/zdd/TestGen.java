package com.zdd;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/1/22 ??4:01
 */
public interface TestGen<S, K> {
    default Integer func()
    {
        return 1;
    }

    default String func1()
    {
        return 1 + "";
    }
}
