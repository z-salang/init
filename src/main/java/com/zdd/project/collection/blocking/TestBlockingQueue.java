package com.zdd.project.collection.blocking;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/12/4 ??7:46
 */
public class TestBlockingQueue {

    public static void main(String[] args) throws InterruptedException {

        //BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>(5);

        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(5);

        for (int i = 0; i < 10; i++) {
            System.out.println("Start to put " + i + " to blocking queue, queue size : " + arrayBlockingQueue.size());
            arrayBlockingQueue.put(i);
        }

        System.out.println("Queue sieze " + arrayBlockingQueue.size());
    }
}
