package com.gao.practice.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(2);
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        Runnable runnable = () -> {
            try {
                barrier.await();
                System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        };
        // 先执行的县城等待后执行的线程，同时执行
        cachedThreadPool.submit(runnable);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cachedThreadPool.submit(runnable);

        cachedThreadPool.shutdown();
    }
}
