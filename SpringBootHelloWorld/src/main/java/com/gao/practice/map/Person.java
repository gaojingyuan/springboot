package com.gao.practice.map;

/**
 * Created by jionglu on 17/3/16.
 */
public class Person {
    private Integer age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int compareTo(Person p){
        return age.compareTo(p.getAge());
    }
}
