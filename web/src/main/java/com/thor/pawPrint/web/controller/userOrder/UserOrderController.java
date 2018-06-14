package com.thor.pawPrint.web.controller.userOrder;

import com.thor.pawPrint.bean.dto.simple.TrueOrFalse;
import com.thor.pawPrint.bean.param.UserOrderPO;
import com.thor.pawPrint.biz.controller.order.UserOrderBiz;
import com.thor.pawPrint.core.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Thor on 2017/2/18.
 * happy coding - 1203!
 */
@Controller
@RequestMapping("userOrder")
@Slf4j
public class UserOrderController {
    @Autowired
    private UserOrderBiz userOrderBiz;

    /**
     * 订单页面
     *
     * @return ModelAndView
     */
    @RequestMapping("userOrderPage")
    public ModelAndView userOrderPage() {
        return new ModelAndView("weChat/userOrder/userOrder");
    }

    /**
     * 下单
     *
     * @param userOrderPO 参数
     * @return 下单是否成功
     */
    @RequestMapping("add")
    @ResponseBody
    public Result<TrueOrFalse> add(UserOrderPO userOrderPO) {
        return userOrderBiz.add(userOrderPO);
    }

}
