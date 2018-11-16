package com.zdd.project.collection.blocking;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/12/20 ??8:55
 */
public class TestDequeue {

    public static void main(String[] args) {
        BlockingDeque<Integer> queue = new LinkedBlockingDeque<>(5);
        try {
            queue.put(1);
            queue.put(2);
            queue.put(3);
            queue.put(4);
            queue.put(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(queue.size());

        for (int i=0; i < 10; ++i) {
            Integer poll = queue.poll();
            System.out.println(poll);
        }
    }
}
