package com.zdd.project.lock.reentrant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/4/6 ??3:49
 */
public class TestCondition {

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Distributor distributor = new Distributor();
        Deliver deliver = new Deliver(distributor);
        Arrival arrival = new Arrival(distributor);


        executorService.execute(arrival);
        executorService.execute(deliver);


    }
}
