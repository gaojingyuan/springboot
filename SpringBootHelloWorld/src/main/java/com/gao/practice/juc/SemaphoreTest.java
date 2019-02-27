package com.gao.practice.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
//        Semaphore semaphore = new Semaphore(2,true); // 可以保证3,4线程的执行顺序
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        Runnable runnable = () -> {
            try {
                semaphore.acquire();
                System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                Thread.sleep(3000);
                System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        // 只有2个线程能同时执行
        cachedThreadPool.submit(runnable);
        cachedThreadPool.submit(runnable);
        cachedThreadPool.submit(runnable);
        cachedThreadPool.submit(runnable);

        cachedThreadPool.shutdown();
    }
}
