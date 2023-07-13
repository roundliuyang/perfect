package com.yly.apollo.core.enums;

public enum ApiTypeEnum {
    API("api", "接口"),
    ONS("ons", "ons");

    private String code;
    private String name;

    private ApiTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }
}
