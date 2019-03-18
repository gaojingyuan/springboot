package com.gao.practice.juc;

import java.util.concurrent.*;

public class FutrueTaskTest {
    public static void main(String[] args) {

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        Callable<Integer> callable = () -> {
            try {
                System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                Thread.sleep(3000);
                System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        };
        FutureTask<Integer> futureTask = new FutureTask(callable);

        cachedThreadPool.submit(futureTask);

        // 取消任务
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        futureTask.cancel(false);

//        try {
//            // 如果超过1000毫秒没返回 抛出TimeoutException异常
//            Integer currentRes = futureTask.get(1000, TimeUnit.MILLISECONDS);
//            System.out.println(currentRes);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        }

        try {
            Integer res = futureTask.get();
            System.out.println(res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        cachedThreadPool.shutdown();

    }
}
