package com.zdd.project.concurrent.executors1;

import com.zdd.project.concurrent.executors.utils.ThreadUtils;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2019/1/12 下午7:23
 */
public class TestMain {

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.work(0, 200000);
        System.out.println("================================================================");

        ThreadUtils.toSleepMillis(2000);
        worker.work(100000, 200000);
    }
}
