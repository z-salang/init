package com.zdd.project.Thread.async.to.sync;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/12/20 下午9:05
 */
public class AsyncCall {
    private Random random = new Random(System.currentTimeMillis());

    private ExecutorService tp = Executors.newSingleThreadExecutor();

    //demo1,2,4,5调用方法
    public void call(BaseDemo demo){

        new Thread(()->{
            long res = random.nextInt(10);

            try {
                Thread.sleep(res*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("start to callback");
            demo.callback(res);
        }).start();
    }

    //demo3调用方法
    public Future<Long> futureCall(){

        return tp.submit(()-> {
            long res = random.nextInt(10);

            try {
                Thread.sleep(res*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return res;
        });

    }

    public void shutdown(){
        tp.shutdown();
    }
}
