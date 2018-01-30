package com.gao.practice.thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jionglu on 17/6/4.
 */
public class ConditionTest {
    public static void main(String[] args) {
//        try {
            ConditionTest t = new ConditionTest();
            new Thread(() -> {
                try {
                    t.conditionWait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
//            Thread.sleep(2000L);
//            new Thread(() -> {
//                try {
//                    t.conditionSignal();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void conditionWait() throws InterruptedException {
        lock.lock();
        try {
            condition.await();
            System.out.println("pass");
        } finally {
            lock.unlock();
        }
    }

    public void conditionSignal() throws InterruptedException {
        lock.lock();
        try {
            condition.signal();
            System.out.println("weak up");
        } finally {
            lock.unlock();
        }
    }
}
