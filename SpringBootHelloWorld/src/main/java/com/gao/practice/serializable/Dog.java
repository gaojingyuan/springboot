package com.gao.practice.serializable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

public class Dog implements Externalizable {
    private int id;
    private int age;
    private String name;

    // 必须存在一个无参构造方法，因为在反序列化时会默认调用无参构造实例化对象
    // 无构造方法报错java.io.InvalidClassException:
    // com.gao.practice.serializable.Dog; no valid constructor
    public Dog() {
    }

    public Dog(int id, int age, String name) {
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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        // 可以在序列化时写非自身的变量
        Date d = new Date();
        out.writeObject(d);
        // 要序列化的变量
        out.writeObject(age);
        out.writeObject(name);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        Date d = (Date) in.readObject();
        System.out.println(d);
        // 反序列化要跟序列化顺序一致
        this.age = (int) in.readObject();
        this.name = (String) in.readObject();
    }
}
