package com.gao.practice.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jionglu on 17/3/16.
 */
public class TestAtomicInteger {
    public static AtomicInteger count = new AtomicInteger(0);

    public static void inc() {

        // 这里延迟1毫秒，使得结果明显
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {

        }
        count.addAndGet(1);
    }

    public static void main(String[] args) throws InterruptedException {

        // 同时启动1000个线程，去进行i++计算，看看实际结果
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    TestAtomicInteger.inc();
                }
            }).start();
        }
        System.out.println(System.currentTimeMillis() - start);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        // 这里每次运行的值都有可能不同,可能为1000
        System.out.println("运行结果:Counter.count=" + TestAtomicInteger.count);
    }
}
