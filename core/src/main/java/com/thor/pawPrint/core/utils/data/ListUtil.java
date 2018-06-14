package com.thor.pawPrint.core.utils.data;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * List工具类
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */
public class ListUtil {
    /**
     * 去重
     *
     * @param source 源数据
     * @param <T>    类型
     * @return 去重后的数据
     */
    public static <T> List<T> distinct(List<T> source) {
        List<T> result = Lists.newArrayList();
        source.stream().filter(temp -> !result.contains(temp)).forEach(result::add);

        return result;
    }

}
