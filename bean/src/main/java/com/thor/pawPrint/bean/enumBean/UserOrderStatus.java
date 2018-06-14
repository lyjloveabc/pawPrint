package com.thor.pawPrint.bean.enumBean;

/**
 * Created by Thor on 2017/2/18.
 * happy coding - 1203!
 */
public enum UserOrderStatus {
    NO_PAY("NO_PAY", "未支付"),
    NO_ORDER("NO_ORDER", "未下单");

    private String code;

    private String name;

    UserOrderStatus(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
