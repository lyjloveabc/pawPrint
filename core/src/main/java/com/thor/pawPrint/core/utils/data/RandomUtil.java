package com.thor.pawPrint.core.utils.data;

import com.thor.pawPrint.core.common.constant.Constant;

/**
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */
public class RandomUtil {
    /**
     * 获取随机数，使用默认区间
     *
     * @return int随机数
     */
    public static int get() {
        return get(Constant.RANDOM_MIN, Constant.RANDOM_MAX);
    }

    /**
     * 获取随机数，指定最大最小值
     *
     * @param min 最小值
     * @param max 最大值
     * @return int随机数
     */
    public static int get(int min, int max) {
        return (int) (min + Math.random() * (max - min + 1));
    }

}
