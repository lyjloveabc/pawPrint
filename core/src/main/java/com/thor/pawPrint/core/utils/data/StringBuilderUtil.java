package com.thor.pawPrint.core.utils.data;

/**
 * StringBuilder工具类
 * Created by Thor on 2017/2/7.
 * happy coding - 1203!
 */
public class StringBuilderUtil {
    /**
     * 拼接字符串数组成为一个StringBuilder对象
     *
     * @param strings 字符串数组
     * @return 拼接字符串数组成为一个StringBuilder对象
     */
    public static StringBuilder connectString(String[] strings) {
        StringBuilder content = new StringBuilder();
        for (String string : strings) {
            content.append(string);
        }

        return content;
    }

}
