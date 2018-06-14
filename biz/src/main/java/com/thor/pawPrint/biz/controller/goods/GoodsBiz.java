package com.thor.pawPrint.biz.controller.goods;

import com.thor.pawPrint.bean.dto.GoodsDTO;
import com.thor.pawPrint.core.common.result.Result;

import java.util.List;

/**
 * Created by Thor on 2017/2/14.
 * happy coding - 1203!
 */
public interface GoodsBiz {
    /**
     * 获取一个销售主题下的所有上架的商品
     *
     * @param goodsIds 商品ID字符串
     * @return 商品列表
     */
    Result<List<GoodsDTO>> goodsInSalesTheme(String goodsIds);

    /**
     * 获取商品详情
     *
     * @param id 商品ID
     * @return 商品详情
     */
    Result<GoodsDTO> goodsDetail(Integer id);

}
