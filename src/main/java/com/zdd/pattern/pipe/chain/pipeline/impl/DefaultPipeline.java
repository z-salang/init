package com.zdd.pattern.pipe.chain.pipeline.impl;

import com.zdd.pattern.pipe.chain.pipeline.Handler;
import com.zdd.pattern.pipe.chain.pipeline.HandlerNode;
import com.zdd.pattern.pipe.chain.pipeline.Pipeline;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/1/10 ??3:37
 */
public class DefaultPipeline implements Pipeline<String> {

    private final Map<String, Handler> handlers = new HashMap<>();

    private AbstractHandlerNode head = new HeadHandlerNode();

    @Override
    public Pipeline addFirst(Handler handler) {
        AbstractHandlerNode node = new DefaultHandlerNode(handler);
        AbstractHandlerNode temp = head;
        head = node;
        head.next = temp;

        handlers.put(handler.getClass().getName(), handler);

        return this;
    }

    @Override
    public void start(String s) {
        head.work(s);
    }

    final class HeadHandlerNode extends AbstractHandlerNode {

        public HeadHandlerNode() {
            super(new HeadHandler());
        }
    }

    final class HeadHandler implements Handler<String> {

        @Override
        public void process(HandlerNode<String> next, String s) {

        }
    }
}
