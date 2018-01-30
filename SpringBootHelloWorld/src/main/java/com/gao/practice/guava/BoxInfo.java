package com.gao.practice.guava;

public class BoxInfo {
    private Integer boxType;
    private String boxNo;

    public BoxInfo(Integer boxType, String boxNo) {
        this.boxType = boxType;
        this.boxNo = boxNo;
    }

    public Integer getBoxType() {
        return boxType;
    }

    public void setBoxType(Integer boxType) {
        this.boxType = boxType;
    }

    public String getBoxNo() {
        return boxNo;
    }

    public void setBoxNo(String boxNo) {
        this.boxNo = boxNo;
    }
}
