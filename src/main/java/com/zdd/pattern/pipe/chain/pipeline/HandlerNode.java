package com.zdd.pattern.pipe.chain.pipeline;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/1/10 ??3:16
 */
public interface HandlerNode<T> {

    void work(T t);

    void doNext(T t);
}
