package com.thor.pawPrint.biz.controller.order;

import com.thor.pawPrint.bean.dto.simple.TrueOrFalse;
import com.thor.pawPrint.bean.param.UserOrderPO;
import com.thor.pawPrint.core.common.result.Result;

/**
 * Created by Thor on 2017/2/20.
 * happy coding - 1203!
 */
public interface UserOrderBiz {
    /**
     * 下单
     *
     * @param userOrderPO 参数
     * @return 下单是否成功
     */
    Result<TrueOrFalse> add(UserOrderPO userOrderPO);

}
