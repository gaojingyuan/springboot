package com.gao.practice.forkjoin;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveAction;

public class TestRecursiveAction extends RecursiveAction {

    private List<Integer> numList;

    public TestRecursiveAction(List<Integer> numList) {
        this.numList = numList;
    }

    @Override
    protected void compute() {
        int sum = 0;
        int size = numList.size();
        boolean canCompute = (size == 1);
        if (canCompute) {
            sum += numList.get(0);
        } else {
            int divide = getDivied(size);
            List<List<Integer>> l = Lists.partition(numList, divide);
            TestRecursiveAction leftTask = new TestRecursiveAction(l.get(0));
            TestRecursiveAction rightTask = new TestRecursiveAction(l.get(1));
            leftTask.fork();
            rightTask.fork();
            leftTask.join();
            rightTask.join();
        }
    }

    private static int getDivied(int size) {
        if (size % 2 == 0) {
            return size / 2;
        } else {
            return (size + 1) / 2;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = Lists.newArrayList(1, 2);
        ForkJoinPool forkJoinPoll = new ForkJoinPool();
        TestRecursiveAction task = new TestRecursiveAction(list);
        Future result = forkJoinPoll.submit(task);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
