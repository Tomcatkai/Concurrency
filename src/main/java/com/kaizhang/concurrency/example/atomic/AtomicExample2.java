package com.kaizhang.concurrency.example.atomic;

import com.kaizhang.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 并发测试类
 *
 * 线程不安全
 * @author kaizhang
 * @create 2019-04-28 20:26
 **/

@Slf4j
@ThreadSafe
public class AtomicExample2 {

    private static AtomicLong count = new AtomicLong(0);

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
        count.incrementAndGet();
        //count.getAndIncrement(); 执行先后顺序之别
    }
}
