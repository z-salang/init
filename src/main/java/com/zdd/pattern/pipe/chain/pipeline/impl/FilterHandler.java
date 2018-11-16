package com.zdd.pattern.pipe.chain.pipeline.impl;

import com.zdd.pattern.pipe.chain.pipeline.Handler;
import com.zdd.pattern.pipe.chain.pipeline.HandlerNode;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/1/10 ??5:14
 */
public class FilterHandler implements Handler<String> {

    private static final String PATTERN = "Sleeping";

    @Override
    public void process(HandlerNode<String> next, String s) {
        System.out.println("Filter Receive: " + s);

        if (s.contains(PATTERN)) {
            String result = s.replaceAll(PATTERN, "");
            System.out.println(result);
            next.doNext(s);
        }
    }
}
