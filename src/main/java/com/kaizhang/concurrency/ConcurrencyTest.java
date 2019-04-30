package com.kaizhang.concurrency;

import com.kaizhang.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 并发测试类
 *
 * 线程不安全
 * @author kaizhang
 * @create 2019-04-28 20:26
 **/

@Slf4j
@NotThreadSafe
public class ConcurrencyTest {

    private static int count = 0;

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        /*
          同时并发执行的线程数
         */
        int threadTotal = 200;
        final Semaphore semaphore = new Semaphore(threadTotal);
        /*
          请求总数
         */
        int clientTotal = 5000;
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++){
            executorService.execute(() ->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                }catch (Exception e){
                    log.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}",count);
    }

    private static void add(){
        count++;
    }
}
