package com.example.constant;

public enum Type {
    TANGTRET("Tầng trệt"), NGUYENCAN("Nguyên căn"), NOITHAT("Nội thất");

    private String value;

    private Type(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
