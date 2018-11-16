package com.zdd.project.lock.reentrant;

import com.zdd.project.concurrent.executors.utils.ThreadUtils;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/4/6 ??5:45
 */
public class Deliver implements Runnable {

    private final Distributor<Goods> distributor;

    private volatile boolean running = true;

    public Deliver(Distributor<Goods> distributor) {
        this.distributor = distributor;
    }

    public void take() throws Exception {
        ThreadUtils.toSleepMillis(5000);
        Goods goods = distributor.deliver();
        System.out.println("Deliver take goods : " + goods.getProduct());
    }

    @Override
    public void run() {
        while (running) {
            try {

                take();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        running = false;
    }
}
