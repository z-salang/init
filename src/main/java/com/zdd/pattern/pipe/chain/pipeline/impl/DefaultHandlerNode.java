package com.zdd.pattern.pipe.chain.pipeline.impl;

import com.zdd.pattern.pipe.chain.pipeline.Handler;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/1/10 ??3:24
 */
public class DefaultHandlerNode extends AbstractHandlerNode<String> {

    public DefaultHandlerNode(Handler handler) {
        super(handler);
    }
}
