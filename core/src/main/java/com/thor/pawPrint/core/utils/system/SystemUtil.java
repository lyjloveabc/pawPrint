package com.thor.pawPrint.core.utils.system;

import com.thor.pawPrint.core.common.constant.Constant;
import org.springframework.util.ObjectUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 常用系统工具
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */
public class SystemUtil {
    /**
     * 验证手机号
     *
     * @param mobile 手机号
     * @return 是否验证通过
     */
    public static boolean isMobile(String mobile) {
        if (ObjectUtils.isEmpty(mobile)) {
            return false;
        }

        Pattern pattern = Pattern.compile("^(13|14|15|17|18)\\d{9}$");
        Matcher matcher = pattern.matcher(mobile);
        return matcher.matches();
    }

    /**
     * 隐藏手机号
     *
     * @param mobile 手机号
     * @return 隐藏后的手机号
     */
    public static String hideMobile(String mobile) {
        if (isMobile(mobile)) {
            String pre = mobile.substring(0, 3);
            String suf = mobile.substring(7);
            return pre + "****" + suf;
        }

        return mobile;
    }

    public static String getGoodsMainImage(String goodsImages) {
        if (ObjectUtils.isEmpty(goodsImages)) {
            return Constant.STRING_EMPTY;
        }

        String[] images = goodsImages.split(Constant.SPLIT_STR_COMMA);

        return images.length > 0 ? images[0] : Constant.STRING_EMPTY;
    }

}
