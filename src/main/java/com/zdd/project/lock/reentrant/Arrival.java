package com.zdd.project.lock.reentrant;

import com.zdd.project.concurrent.executors.utils.ThreadUtils;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/4/6 ??5:46
 */
public class Arrival implements Runnable {

    private final Distributor<Goods> distributor;

    private volatile boolean running = true;

    public Arrival(Distributor<Goods> distributor) {
        this.distributor = distributor;
    }

    public void send(Goods goods) throws Exception {
        distributor.arrival(goods);
    }

    @Override
    public void run() {
        while (running) {
            for (int i = 1; ; ++i) {
                try {
                    ThreadUtils.toSleepMillis(1000);

                    Goods product = new Goods("product-" + i);
                    send(product);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public void stop() {
        running = false;
    }
}
