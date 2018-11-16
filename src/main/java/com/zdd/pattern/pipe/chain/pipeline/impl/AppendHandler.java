package com.zdd.pattern.pipe.chain.pipeline.impl;

import com.zdd.pattern.pipe.chain.pipeline.Handler;
import com.zdd.pattern.pipe.chain.pipeline.HandlerNode;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/1/10 ??3:23
 */
public class AppendHandler implements Handler<String> {

    private static final String CONTENT = "I am coding ..";

    @Override
    public void process(HandlerNode<String> next, String s) {
        System.out.println("Appender Receive: " + s);

        if (!s.contains(CONTENT)) {
            s += CONTENT;
            System.out.println(s);
            next.doNext(s);
        }
    }
}
