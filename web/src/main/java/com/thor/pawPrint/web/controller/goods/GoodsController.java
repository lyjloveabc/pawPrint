package com.thor.pawPrint.web.controller.goods;

import com.thor.pawPrint.bean.dto.GoodsDTO;
import com.thor.pawPrint.biz.controller.goods.GoodsBiz;
import com.thor.pawPrint.core.common.constant.Constant;
import com.thor.pawPrint.core.common.result.Result;
import com.thor.pawPrint.core.common.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 商品
 * Created by Thor on 2017/2/13.
 * happy coding - 1203!
 */
@Controller
@RequestMapping("goods")
@Slf4j
public class GoodsController {
    @Autowired
    private GoodsBiz goodsBiz;

    /**
     * 销售主题页
     *
     * @return ModelAndView
     */
    @RequestMapping("goodsPage")
    public ModelAndView goodsPage(String goodsIds) {
        ModelAndView modelAndView = new ModelAndView("weChat/goods/goods");
        modelAndView.addObject("goodsIds", goodsIds);

        return modelAndView;
    }

    @RequestMapping("goodsDetailPage")
    public ModelAndView goodsDetailPage(Integer id) {
        ModelAndView modelAndView = new ModelAndView("weChat/goodsDetail/goodsDetail");

        Result<GoodsDTO> goodsResult = goodsBiz.goodsDetail(id);
        if (ResultCode.isSuccess(goodsResult.getCode())) {
            modelAndView.addObject("goodsDetail", goodsResult.getData());
        }

        return modelAndView;
    }

    /**
     * 获取一个销售主题下的所有上架的商品
     *
     * @param goodsIds 商品ID字符串
     * @return 商品列表
     */
    @RequestMapping("goodsInSalesTheme")
    @ResponseBody
    public Result<List<GoodsDTO>> goodsInSalesTheme(String goodsIds) {
        return goodsBiz.goodsInSalesTheme(goodsIds);
    }

    /**
     * 获取商品详情
     *
     * @param id 商品ID
     * @return 商品详情
     */
    @RequestMapping("goodsDetail")
    @ResponseBody
    public Result<GoodsDTO> goodsDetail(Integer id) {
        return goodsBiz.goodsDetail(id);
    }

}
