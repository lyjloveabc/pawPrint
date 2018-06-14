package com.thor.pawPrint.core.utils.data;

import com.thor.pawPrint.core.common.constant.Constant;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;

/**
 * 金额工具类
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */
public class MoneyUtil {
    /**
     * 保留两位小数、四舍五入
     *
     * @param money 金额数据
     * @return 保留两位小数后的金额数据
     */
    public static BigDecimal format(BigDecimal money) {
        if (ObjectUtils.isEmpty(money)) {
            return new BigDecimal(0);
        }

        return money.setScale(Constant.DECIMAL_DIGITS, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 保留两位小数、四舍五入
     *
     * @param money 金额数据
     * @return 保留两位小数后的金额数据
     */
    public static BigDecimal format(double money) {
        if (ObjectUtils.isEmpty(money)) {
            return new BigDecimal(0);
        }

        return new BigDecimal(money).setScale(Constant.DECIMAL_DIGITS, BigDecimal.ROUND_HALF_UP);
    }

}
