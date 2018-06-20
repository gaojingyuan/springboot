package com.gao.drools;

public class ApplyInfo implements java.io.Serializable {

    static final long serialVersionUID = 1L;

    @org.kie.api.definition.type.Label("姓名")
    private java.lang.String name;
    @org.kie.api.definition.type.Label("年龄")
    private Integer age;
    @org.kie.api.definition.type.Label("家庭地址")
    private Address familyAddress;

    public ApplyInfo() {
    }

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public Address getFamilyAddress() {
        return this.familyAddress;
    }

    public void setFamilyAddress(Address familyAddress) {
        this.familyAddress = familyAddress;
    }

    public java.lang.Integer getAge() {
        return this.age;
    }

    public void setAge(java.lang.Integer age) {
        this.age = age;
    }

    public ApplyInfo(java.lang.String name, java.lang.Integer age,
                     Address familyAddress) {
        this.name = name;
        this.age = age;
        this.familyAddress = familyAddress;
    }

}