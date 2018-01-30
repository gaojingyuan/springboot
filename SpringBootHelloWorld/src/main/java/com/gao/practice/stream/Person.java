package com.gao.practice.stream;

class Person{
    private Integer age;
    private String name;
    private String sexy;

    public Person(Integer id, String name, String sexy) {
        this.age = id;
        this.name = name;
        this.sexy = sexy;
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

    public String getSexy() {
        return sexy;
    }

    public void setSexy(String sexy) {
        this.sexy = sexy;
    }
}
