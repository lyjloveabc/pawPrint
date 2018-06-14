package com.thor.pawPrint.core.utils.console;

/**
 * 控制台输出工具类
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */
public class PrintUtil {
    /**
     * 打印1个空行
     */
    public static void printEmptyLine() {
        System.out.println();
    }

    /**
     * 打印n个空行
     *
     * @param num 空行的个数
     */
    public static void printEmptyLines(Integer num) {
        for (int i = 0; i < num; i++) {
            System.out.println();
        }
    }

}
