package com.zdd.project.exceptions.continuous_throw;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/3/10 ??4:49
 */
public class Processor {

    private final MyHandler myHandler;

    public Processor() {
        myHandler = new MyHandler();
    }

    public void process() {
        myHandler.handle();
    }
}
