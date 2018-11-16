package com.zdd.pattern.pipe.chain.pipeline.impl;

import com.zdd.pattern.pipe.chain.pipeline.Handler;
import com.zdd.pattern.pipe.chain.pipeline.HandlerNode;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/1/10 ??3:18
 */
public abstract class AbstractHandlerNode<T> implements HandlerNode<T> {

    private final Handler handler;

    protected AbstractHandlerNode next;

    public AbstractHandlerNode(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void work(T t) {
        if (next == null) {
            return;
        } else {
            handler.process(next, t);
        }
    }

    @Override
    public void doNext(T t) {
        work(t);
    }

}
