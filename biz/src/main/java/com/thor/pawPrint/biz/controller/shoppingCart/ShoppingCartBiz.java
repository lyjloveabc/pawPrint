package com.thor.pawPrint.biz.controller.shoppingCart;

import com.thor.pawPrint.bean.dto.ShoppingCartXGoodsDTO;
import com.thor.pawPrint.bean.dto.simple.TrueOrFalse;
import com.thor.pawPrint.bean.param.ShoppingCartPO;
import com.thor.pawPrint.core.common.result.Result;

import java.util.List;

/**
 * Created by Thor on 2017/2/14.
 * happy coding - 1203!
 */
public interface ShoppingCartBiz {
    /**
     * 添加一条购物记录到购物车
     *
     * @param shoppingCartPO 入参
     * @return 添加是否成功
     */
    Result<TrueOrFalse> add(ShoppingCartPO shoppingCartPO);

    /**
     * 获取用户的购物车列表
     *
     * @return 用户的购物车列表
     */
    Result<List<ShoppingCartXGoodsDTO>> userShoppingCarts();

}
