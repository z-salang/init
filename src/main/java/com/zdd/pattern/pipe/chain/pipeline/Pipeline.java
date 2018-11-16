package com.zdd.pattern.pipe.chain.pipeline;

/**
 * half-duplex pipeline
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/1/10 ??3:06
 */
public interface Pipeline<T> {

    Pipeline addFirst(Handler handler);

    void start(T t);
}
