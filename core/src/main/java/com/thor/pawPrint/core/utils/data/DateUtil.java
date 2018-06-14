package com.thor.pawPrint.core.utils.data;

import com.thor.pawPrint.core.common.constant.Constant;
import com.thor.pawPrint.core.common.constant.DateConstant;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.util.ObjectUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */
public class DateUtil {
    /**
     * Date类型转字符串类型，使用默认格式
     *
     * @param date date
     * @return 时间字符串
     */
    public static String dateToString(Date date) {
        return dateToString(date, DateConstant.DEFAULT_FORMAT);
    }

    /**
     * Date类型转字符串类型，使用指定格式
     *
     * @param date   date
     * @param format 时间格式
     * @return 时间字符串
     */
    public static String dateToString(Date date, String format) {
        if (ObjectUtils.isEmpty(format)) {
            format = DateConstant.DEFAULT_FORMAT;
        }

        DateTime dateTime = new DateTime(date);
        DateTimeFormatter formatter = DateTimeFormat.forPattern(format);

        return dateTime.toString(formatter);
    }

    /**
     * 时间字符串转date，使用默认格式
     *
     * @param date 时间字符串
     * @return date
     */
    public static Date stringToDate(String date) {
        return stringToDate(date, DateConstant.DEFAULT_FORMAT);
    }

    /**
     * 时间字符串转date，使用指定格式
     *
     * @param date   时间字符串
     * @param format 指定格式
     * @return date
     */
    public static Date stringToDate(String date, String format) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(format);
        DateTime dateTime = DateTime.parse(date, formatter);

        return dateTime.toDate();
    }

    public static Date now() {
        return new Date();
    }

    /**
     * 获取系统当前时间戳
     *
     * @return long型的时间戳
     */
    public static long getTimestamp() {
        return System.currentTimeMillis();
    }

    /**
     * 获取系统当前时间戳, unix版本（unix时间戳是从1970年1月1日（UTC/GMT的午夜）开始所经过的秒数，不考虑闰秒）
     *
     * @return long型的时间戳
     */
    public static Integer getUnixTimestamp() {
        return (int) (getTimestamp() / 1000);
    }

    /**
     * 获取当天时间的前d天（-d）或者后d天的时间
     *
     * @param d       加减天数
     * @param pattern 格式化的日期格式
     * @return 满足格式的日期String
     */
    public static String getFewDaysAgoOrAfterDate(Integer d, String pattern) {
        return getFewDaysAgoOrAfterDate(null, d, pattern);
    }

    /**
     * 获取当天时间的前d天（-d）或者后d天的时间
     *
     * @param cal     基准时间
     * @param d       加减天数
     * @param pattern 格式化的日期格式
     * @return 满足格式的日期String
     */
    public static String getFewDaysAgoOrAfterDate(Calendar cal, Integer d, String pattern) {
        Calendar calendar = cal == null ? Calendar.getInstance() : (Calendar) cal.clone();
        calendar.add(Calendar.DATE, d);
        Date date = new Date(calendar.getTimeInMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    /**
     * 获取上一个月
     *
     * @param yearMonth 年月字符串
     * @return 上一个月
     */
    public static Date getLastMonth(String yearMonth) {
        return getMonthBySpace(yearMonth, -1);
    }

    /**
     * 以yearMonth为基准获取间隔space月份，日期为最后一天
     *
     * @param yearMonth 年月
     * @param space     间隔
     * @return date
     */
    public static Date getMonthBySpace(String yearMonth, int space) {
        String[] ym = yearMonth.split(Constant.SPLIT_STR_BAR);
        Integer year = Integer.parseInt(ym[0]);
        Integer month = Integer.parseInt(ym[1]) - 1;//月份是从0开始的

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.add(Calendar.MONTH, space);

        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));

        return calendar.getTime();
    }

    /**
     * 以yearMonth为基准获取间隔space月份，日期为指定日期
     *
     * @param yearMonth 年月
     * @param space     间隔
     * @param date      指定日期
     * @return date
     */
    public static Date getMonthBySpace(String yearMonth, int space, int date) {
        String[] ym = yearMonth.split(Constant.SPLIT_STR_BAR);
        Integer year = Integer.parseInt(ym[0]);
        Integer month = Integer.parseInt(ym[1]) - 1;//月份是从0开始的

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.add(Calendar.MONTH, space);

        calendar.set(Calendar.DATE, date);

        return calendar.getTime();
    }

}
