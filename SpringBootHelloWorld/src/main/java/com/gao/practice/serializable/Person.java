package com.gao.practice.serializable;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 8500678125995642754L;
    transient private int id;
    private static int age;
    private String name;
    private String favor;

    public Person(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavor() {
        return favor;
    }

    public void setFavor(String favor) {
        this.favor = favor;
    }
}
