package com.gao.drools;

public class Address implements java.io.Serializable {

    static final long serialVersionUID = 1L;

    @org.kie.api.definition.type.Label(value = "\u57CE\u5E02")
    private java.lang.String city;
    @org.kie.api.definition.type.Label(value = "\u8BE6\u7EC6\u5730\u5740")
    private java.lang.String detail;
    @org.kie.api.definition.type.Label(value = "\u533A")
    private java.lang.String distract;
    @org.kie.api.definition.type.Label(value = "\u7701")
    private java.lang.String province;

    public Address() {
    }

    public java.lang.String getCity() {
        return this.city;
    }

    public void setCity(java.lang.String city) {
        this.city = city;
    }

    public java.lang.String getDetail() {
        return this.detail;
    }

    public void setDetail(java.lang.String detail) {
        this.detail = detail;
    }

    public java.lang.String getDistract() {
        return this.distract;
    }

    public void setDistract(java.lang.String distract) {
        this.distract = distract;
    }

    public java.lang.String getProvince() {
        return this.province;
    }

    public void setProvince(java.lang.String province) {
        this.province = province;
    }

    public Address(java.lang.String city, java.lang.String detail,
                   java.lang.String distract, java.lang.String province) {
        this.city = city;
        this.detail = detail;
        this.distract = distract;
        this.province = province;
    }

}