package com.gao.practice.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Runnable runnable = () -> {
            try {
                lock.lock();
                System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                Thread.sleep(3000);
                System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                lock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        cachedThreadPool.submit(runnable);
        cachedThreadPool.submit(runnable);

        cachedThreadPool.shutdown();
    }
}
