package com.zdd.pattern.pipe.chain.pipeline.impl;

import com.zdd.pattern.pipe.chain.pipeline.Handler;
import com.zdd.pattern.pipe.chain.pipeline.HandlerNode;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/1/10 ??5:49
 */
public class FunnyHandler implements Handler<String> {

    @Override
    public void process(HandlerNode<String> next, String s) {
        System.out.println("Funny Receive: " + s);
        s += "funny &*(&*( funny ..";
        System.out.println(s);
        next.doNext(s);
    }
}
