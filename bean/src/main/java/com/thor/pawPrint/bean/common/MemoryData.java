package com.thor.pawPrint.bean.common;

/**
 * 内存数据，只加载一次，提高性能
 * Created by Thor on 2017/2/18.
 * happy coding - 1203!
 */
public class MemoryData {
    private static final Integer START = 1111;
    private static final Integer END = 9999;

    //用于购物车和订单的number
    private static String NUMBER_SUFFIX = String.valueOf(START);

    public static String getNumberSuffix() {
        int ns = Integer.parseInt(NUMBER_SUFFIX);

        if (ns >= END) {
            ns = START;
        } else {
            ns++;
        }

        NUMBER_SUFFIX = String.valueOf(ns);

        return NUMBER_SUFFIX;
    }

}
