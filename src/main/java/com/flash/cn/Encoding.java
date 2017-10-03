package com.flash.cn;

/**
 * @author kay
 * @version v1.0
 */
public enum Encoding {
    UTF8("UTF-8");

    private String code;

    Encoding(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
