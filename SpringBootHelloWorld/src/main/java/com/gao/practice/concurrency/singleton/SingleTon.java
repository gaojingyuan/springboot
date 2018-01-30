package com.gao.practice.concurrency.singleton;

/**
 * Created by jionglu on 17/3/19.
 */
public class SingleTon {
    private static SingleTon singleTon = null;

    private SingleTon() {
    }

    public static SingleTon getInstance() {
//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        if (singleTon == null) {
            synchronized (SingleTon.class) {
                if (singleTon == null) {
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                System.out.println(SingleTon.getInstance());
            }).start();
        }
    }
}
