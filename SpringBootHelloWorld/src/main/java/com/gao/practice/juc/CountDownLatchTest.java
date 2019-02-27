package com.gao.practice.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        Runnable runnable = () -> {
            try {
                System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                Thread.sleep(3000);
                System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        cachedThreadPool.submit(runnable);
        cachedThreadPool.submit(runnable);

        try {
            System.out.println("等待2个子线程执行完毕");
            latch.await();
            System.out.println("子线程已经执行完毕...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        cachedThreadPool.shutdown();
    }
}
