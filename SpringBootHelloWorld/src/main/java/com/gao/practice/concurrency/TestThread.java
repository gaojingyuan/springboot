package com.gao.practice.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by gaocaili on 2017/3/22.
 */

public class TestThread {

//    private volatile int count = 0;
    static AtomicInteger atomicInteger = new AtomicInteger(0);


    public static void main(String[] args) {
        try {
            TestThread t = new TestThread();
            t.startThread1();
            t.startThread2();
            Thread.sleep(3000);
            System.out.println("result = " + atomicInteger);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startThread1(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i =0 ;i<1000;i++){
//                    count++;
                    System.out.println("1 count = " + atomicInteger.decrementAndGet());
                }
            }
        }).start();
    }

    public void startThread2(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i =0 ;i<1000;i++){
//                    count--;
                    System.out.println("2 count = " + atomicInteger.incrementAndGet());
                }
            }
        }).start();
    }
}
