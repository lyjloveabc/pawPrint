package com.thor.pawPrint.bean.dto.simple;

import com.thor.pawPrint.core.common.constant.Constant;
import lombok.Data;

/**
 * 成功或者失败
 * Created by Thor on 2017/2/10.
 * happy coding - 1203!
 */
@Data
public class TrueOrFalse {
    private String doResult;

    private TrueOrFalse(String doResult) {
        this.doResult = doResult;
    }

    public static TrueOrFalse getTrue() {
        return new TrueOrFalse(Constant.TRUE_STRING);
    }

    public static TrueOrFalse getFalse() {
        return new TrueOrFalse(Constant.FALSE_STRING);
    }

}
