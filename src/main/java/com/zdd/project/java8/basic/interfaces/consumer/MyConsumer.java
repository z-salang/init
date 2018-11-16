package com.zdd.project.java8.basic.interfaces.consumer;

import java.util.Objects;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/3/5 ??12:53
 */
public interface MyConsumer<T> {

    void consume(T t);

    default MyConsumer<T> addThen(MyConsumer<? super T> after) {
        Objects.requireNonNull(after);
        return (T t) -> {
            consume(t);
            after.consume(t);
        };
    }
}
