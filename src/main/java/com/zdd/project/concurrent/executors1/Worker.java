package com.zdd.project.concurrent.executors1;

import com.zdd.project.concurrent.NamedThreadFactory;
import com.zdd.project.concurrent.executors.utils.ThreadUtils;

import org.apache.commons.collections.CollectionUtils;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2019/1/12 下午7:15
 */
public class Worker {
    private final BlockingQueue<IdRange> idRangeQueue = new LinkedBlockingQueue<>();
    private ExecutorService executorService;
    private CountDownLatch latch;

    private static final int SEGMENT = 1000;

    public void work(long start, long end) {
        executorService = Executors.newFixedThreadPool(3,
                new NamedThreadFactory("ChargedLogGenerate"));

        List<IdRange> idRanges = IdRange.allocationIdRange(start, end, SEGMENT);
        if (CollectionUtils.isEmpty(idRanges)) {
            return;
        }

        latch = new CountDownLatch(idRanges.size());
        idRangeQueue.addAll(idRanges);

        while (!idRangeQueue.isEmpty()) {
            try {
                IdRange idRange = idRangeQueue.take();
                executorService.execute(new WorkThread(idRange, latch));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        waitFor();

        executorService.shutdown();
        System.out.println("Complete to execute ....");

    }

    private void waitFor() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class WorkThread implements Runnable {
        private IdRange idRange;
        private CountDownLatch latch;

        public WorkThread(IdRange idRange, CountDownLatch latch) {
            this.idRange = idRange;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                System.out.println("start to get log which id between " + idRange.getFrom() + " and " + idRange.getTo());
                ThreadUtils.toSleepMillis(500);
            } finally {
                latch.countDown();
            }
        }
    }
}
