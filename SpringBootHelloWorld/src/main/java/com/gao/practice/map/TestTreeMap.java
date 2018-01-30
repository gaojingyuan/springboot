package com.gao.practice.map;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jionglu on 17/3/16.
 */
public class TestTreeMap {
    public static void main(String[] args) {
        Person p1 = new Person(12, "aa");
        Person p2 = new Person(15, "bb");
        Person p3 = new Person(20, "cc");
        Person p4 = new Person(18, "cc");

        TreeMap<Person, String> treeMap = new TreeMap<Person, String>(new Comparator<Person>() {
            /*
             * 返回负数表示：p1 小于p2，
             * 返回0 表示：p1和p2相等，
             * 返回正数表示：p1大于p2。
             */
            public int compare(Person p1, Person p2) {
                return p1.compareTo(p2);
            }
        });
        treeMap.put(p1, p1.getName());
        treeMap.put(p2, p2.getName());
        treeMap.put(p3, p3.getName());
        treeMap.put(p4, p4.getName());

        for (Map.Entry<Person, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey().getAge());
            System.out.println(entry.getKey().getName());
        }

        ConcurrentHashMap map = new ConcurrentHashMap();
        TreeMap map1 = new TreeMap();
        LinkedHashMap map2 = new LinkedHashMap();
    }
}
