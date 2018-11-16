package com.zdd.project.lock.reentrant;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/4/6 ??3:51
 */
public class Distributor<T> {

    private final Lock lock = new ReentrantLock();
    private final Condition arrivalCondition = lock.newCondition();
    private final Condition deliverCondition = lock.newCondition();

    private boolean running = true;
    private T goods;

    public void arrival(T t) throws Exception {
        Objects.requireNonNull(t);

        lock.lock();
        try {

            if (!running) {
                return;
            }

            while (!isEmpty()) {
                arrivalCondition.await();
                System.out.println("ARRIVAL - storage is not empty, arrival goods must be wait ..." + timeMark());
            }

            System.out.println("ARRIVAL - storage is empty now, arrival goods can be stored ..." + timeMark());

            this.goods = t;
            System.out.println("ARRIVAL - goods is already, start to deliver " + timeMark());
            deliverCondition.signalAll();

        } finally {
            lock.unlock();
        }
    }

    public T deliver() throws Exception {
        lock.lock();
        try {

            if (!running) {
                return null;
            }

            while (isEmpty()) {
                deliverCondition.wait();
                System.out.println("DELIVER - storage is empty, deliver must be wait ..." + timeMark());
            }

            System.out.println("DELIVER - storage is not empty now, goods ready to be delivered ..." + timeMark());

            T t = this.goods;
            this.goods = null;
            System.out.println("DELIVER - storage is empty, start to receive arrival goods ... " + timeMark());
            arrivalCondition.signalAll();

            return t;
        } finally {
            lock.unlock();
        }
    }

    public void close() {
        lock.lock();
        try {
            running = false;
        } finally {
            lock.unlock();
        }
    }

    private boolean isEmpty() {
        return goods == null;
    }

    private LocalDateTime timeMark() {
        return LocalDateTime.now();
    }
}
