package com.gao.practice.forkjoin;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class TestRecursiveTask extends RecursiveTask<Integer> {

    private List<Integer> numList;

    public TestRecursiveTask(List<Integer> numList) {
        this.numList = numList;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        int size = numList.size();
        if (size == 1) {
            sum += numList.get(0);
        } else {
            int divide = getDivied(size);
            List<List<Integer>> l = Lists.partition(numList, divide);
            TestRecursiveTask leftTask = new TestRecursiveTask(l.get(0));
            TestRecursiveTask rightTask = new TestRecursiveTask(l.get(1));
            leftTask.fork();
            rightTask.fork();
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            sum = leftResult + rightResult;
        }
        return sum;
    }

    private static int getDivied(int size) {
        if (size % 2 == 0) {
            return size / 2;
        } else {
            return (size + 1) / 2;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5);
        ForkJoinPool forkJoinPoll = new ForkJoinPool();
        TestRecursiveTask task = new TestRecursiveTask(list);
        Future<Integer> result = forkJoinPoll.submit(task);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
