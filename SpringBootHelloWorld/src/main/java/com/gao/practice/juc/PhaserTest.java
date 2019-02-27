package com.gao.practice.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserTest {
    public static void main(String[] args) {
        // 初始参与的线程个数
        Phaser phaser = new Phaser(2);
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        Runnable runnable1 = () -> {
            System.out.println("子线程" + Thread.currentThread().getName() + "阶段1完成");
            phaser.arriveAndAwaitAdvance();
            System.out.println("子线程" + Thread.currentThread().getName() + "阶段2完成");
            phaser.arriveAndAwaitAdvance();
            System.out.println("子线程" + Thread.currentThread().getName() + "阶段3完成");
            phaser.arriveAndDeregister();
        };
        Runnable runnable2 = () -> {
            try {
                Thread.sleep(3000);
                System.out.println("子线程" + Thread.currentThread().getName() + "阶段1完成");
                phaser.arriveAndAwaitAdvance();
                Thread.sleep(3000);
                System.out.println("子线程" + Thread.currentThread().getName() + "阶段2完成");
                phaser.arriveAndAwaitAdvance();
                Thread.sleep(3000);
                System.out.println("子线程" + Thread.currentThread().getName() + "阶段3完成");
                phaser.arriveAndDeregister();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        cachedThreadPool.submit(runnable1);
        cachedThreadPool.submit(runnable2);

        // 动态把当前线程加入到phaser中，这样相当于new Phaser(3);
        phaser.register();
        System.out.println("子线程" + Thread.currentThread().getName() + "阶段1完成");
        phaser.arriveAndAwaitAdvance();
        System.out.println("子线程" + Thread.currentThread().getName() + "阶段2完成");
        phaser.arriveAndAwaitAdvance();
        System.out.println("子线程" + Thread.currentThread().getName() + "阶段3完成");
        phaser.arriveAndDeregister();

        cachedThreadPool.shutdown();
    }
}
