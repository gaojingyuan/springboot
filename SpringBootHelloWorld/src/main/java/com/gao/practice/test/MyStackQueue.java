package com.gao.practice.test;

import java.util.Stack;

public class MyStackQueue {
    private Stack stack = new Stack();
    private Stack convertStack = new Stack();

    public void enqueue(Object o) {
        stack.push(o);
    }

    public Object dequeue() {
        if (convertStack.isEmpty()) {
            while (!stack.isEmpty()) {
                convertStack.push(stack.pop());
            }
        }
        return convertStack.pop();
    }

    public static void main(String[] args) {


        MyStackQueue mq = new MyStackQueue();

        mq.enqueue(1);
        mq.enqueue(2);
        mq.enqueue(3);

        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
    }
}
