package com.zdd.project.Thread.async.to.sync;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/12/20 下午9:06
 */
public abstract class BaseDemo {
    protected AsyncCall asyncCall = new AsyncCall();

    public abstract void callback(long response);

    public void call() {
        System.out.println("发起调用");
        asyncCall.call(this);
        System.out.println("调用返回");
    }
}
