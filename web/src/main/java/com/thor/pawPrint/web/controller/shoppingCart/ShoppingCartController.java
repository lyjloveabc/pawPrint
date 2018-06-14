package com.thor.pawPrint.web.controller.shoppingCart;

import com.thor.pawPrint.bean.dto.ShoppingCartXGoodsDTO;
import com.thor.pawPrint.bean.dto.simple.TrueOrFalse;
import com.thor.pawPrint.bean.param.ShoppingCartPO;
import com.thor.pawPrint.biz.controller.shoppingCart.ShoppingCartBiz;
import com.thor.pawPrint.core.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Thor on 2017/2/14.
 * happy coding - 1203!
 */
@Controller
@RequestMapping("shoppingCart")
@Slf4j
public class ShoppingCartController {
    @Autowired
    private ShoppingCartBiz shoppingCartBiz;

    /**
     * 购物车页面
     *
     * @return ModelAndView
     */
    @RequestMapping("shoppingCartPage")
    public ModelAndView shoppingCartPage() {
        return new ModelAndView("weChat/shoppingCart/shoppingCart");
    }

    /**
     * 添加一条购物记录到购物车
     *
     * @param shoppingCartPO 入参
     * @return 添加是否成功
     */
    @RequestMapping("add")
    @ResponseBody
    public Result<TrueOrFalse> add(ShoppingCartPO shoppingCartPO) {
        return shoppingCartBiz.add(shoppingCartPO);
    }

    @RequestMapping("delete")
    @ResponseBody
    public Result<TrueOrFalse> delete(ShoppingCartPO shoppingCartPO) {
        return shoppingCartBiz.add(shoppingCartPO);
    }

    @RequestMapping("modify")
    @ResponseBody
    public Result<TrueOrFalse> modify(ShoppingCartPO shoppingCartPO) {
        return shoppingCartBiz.add(shoppingCartPO);
    }

    /**
     * 获取用户的购物车列表
     *
     * @return 用户的购物车列表
     */
    @RequestMapping("userShoppingCarts")
    @ResponseBody
    public Result<List<ShoppingCartXGoodsDTO>> userShoppingCarts() {
        return shoppingCartBiz.userShoppingCarts();
    }

}
