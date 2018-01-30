package com.gao.practice.genericity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class GenericityTest {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        List<Integer> list2 = new ArrayList<Integer>();
        fun(list1);
        fun(list2);

        String a = new String("0");
        Integer b = new Integer(0);
        f1(a);
        f1(b);
    }

    public static <T> void fun(List<T> list){
        System.out.println(list.size());
    }

    public static <T> void f1(T t){
        System.out.println(t);
    }


}
