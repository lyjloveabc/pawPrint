package com.thor.pawPrint.core.utils.data;

import com.google.common.collect.Lists;
import com.thor.pawPrint.core.common.constant.Constant;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */
public class StringUtil {
    /**
     * 字符串转整型数组
     *
     * @param string 原始字符串
     * @return Integer数组
     */
    public static Integer[] stringToIntArray(String string) {
        return stringToIntArray(string, Constant.SPLIT_STR_COMMA);
    }

    /**
     * 字符串转整型数组
     *
     * @param string   原始字符串
     * @param splitStr 分隔符
     * @return Integer数组
     */
    public static Integer[] stringToIntArray(String string, String splitStr) {
        String[] idStr = string.split(splitStr);
        Integer[] idInt = new Integer[idStr.length];
        for (int i = 0; i < idStr.length; i++) {
            idInt[i] = Integer.parseInt(idStr[i]);
        }

        return idInt;
    }

    /**
     * 字符串转整型集合
     *
     * @param string 字符串
     * @return 整型集合
     */
    public static List<Integer> stringToIntList(String string) {
        return stringToIntList(string, Constant.SPLIT_STR_COMMA);
    }

    /**
     * 字符串转整型集合
     *
     * @param string   字符串
     * @param splitStr 分隔符
     * @return 整型集合
     */
    public static List<Integer> stringToIntList(String string, String splitStr) {
        List<Integer> result = Lists.newArrayList();
        String[] idStr = string.split(splitStr);
        for (String anIdStr : idStr) {
            result.add(Integer.parseInt(anIdStr));
        }

        return result;
    }

    /**
     * 移除空字符串
     *
     * @param strings 字符串数组
     * @return 移除空字符串之后的集合
     */
    public static List<String> removeEmpty(String[] strings) {
        List<String> result = Lists.newArrayList();

        if (ObjectUtils.isEmpty(strings)) {
            return result;
        }

        for (String item : strings) {
            if (!ObjectUtils.isEmpty(item)) {
                result.add(item);
            }
        }

        return result;
    }

    /**
     * 删除前置0
     *
     * @param numStr 数值型字符串
     * @return 删除前置0后的字符串
     */
    public static String deletePreZero(String numStr) {
        Integer num = Integer.parseInt(numStr);
        return String.valueOf(num);
    }

    /**
     * 判断字符串是否是全是数字
     *
     * @param str 字符串
     * @return 是true
     */
    public static boolean isNumeric(String str) {
        if (ObjectUtils.isEmpty(str)) {
            return false;
        }

        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher isNum = pattern.matcher(str);

        return isNum.matches();
    }

    public static boolean isValidIdString(String idString) {
        if (ObjectUtils.isEmpty(idString)) {
            return false;
        }

        Pattern pattern = Pattern.compile("([0-9]+)[0-9,]*([0-9]*)");
        Matcher isValidIdString = pattern.matcher(idString);

        return isValidIdString.matches();
    }

    public static void main(String[] args) {
        System.out.println(isNumeric(""));
        System.out.println(isValidIdString("1,,1"));
//        System.out.println(isNumeric(null));
//        System.out.println(isNumeric("1.1"));
    }

}
