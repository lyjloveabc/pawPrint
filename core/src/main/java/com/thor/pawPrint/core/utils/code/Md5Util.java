package com.thor.pawPrint.core.utils.code;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;

/**
 * MD5相关操作
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */
@Slf4j
public class Md5Util {
    /**
     * MD5加密
     *
     * @param before 原始值
     * @return 加密后的值
     */
    public static String MD5(String before) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        try {
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");

            // 使用指定的字节更新摘要
            mdInst.update(before.getBytes());
            byte[] md = mdInst.digest();

            // 把密文转换成十六进制的字符串形式
            char str[] = new char[md.length * 2];
            int k = 0;
            for (byte item : md) {
                str[k++] = hexDigits[item >>> 4 & 0xf];
                str[k++] = hexDigits[item & 0xf];
            }

            return String.valueOf(str).toLowerCase();
        } catch (Exception e) {
            log.error("MD5加密失败, param:" + before, e);
            return before;
        }
    }

}