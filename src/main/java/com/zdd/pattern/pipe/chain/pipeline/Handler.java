package com.zdd.pattern.pipe.chain.pipeline;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/1/10 ??3:15
 */
public interface Handler<T> {

    void process(HandlerNode<T> context, T t);
}
