package com.thor.pawPrint.biz.controller.order;

import com.thor.pawPrint.bean.common.MemoryData;
import com.thor.pawPrint.bean.dto.simple.TrueOrFalse;
import com.thor.pawPrint.bean.entity.UserOrderDO;
import com.thor.pawPrint.bean.enumBean.ShoppingCartStatus;
import com.thor.pawPrint.bean.enumBean.UserOrderStatus;
import com.thor.pawPrint.bean.param.UserOrderPO;
import com.thor.pawPrint.core.common.constant.Constant;
import com.thor.pawPrint.core.common.constant.DateConstant;
import com.thor.pawPrint.core.common.result.Result;
import com.thor.pawPrint.core.common.result.ResultCode;
import com.thor.pawPrint.core.utils.data.DateUtil;
import com.thor.pawPrint.core.utils.object.ObjectCopyUtil;
import com.thor.pawPrint.core.utils.system.ResultUtil;
import com.thor.pawPrint.dao.daoTemp.ShoppingCartDAO;
import com.thor.pawPrint.dao.daoTemp.UserOrderDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Thor on 2017/2/20.
 * happy coding - 1203!
 */
@Service
@Slf4j
public class UserOrderBizImpl implements UserOrderBiz {
    @Autowired
    private UserOrderDAO userOrderDAO;

    @Autowired
    private ShoppingCartDAO shoppingCartDAO;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Override
    public Result<TrueOrFalse> add(UserOrderPO userOrderPO) {
        if (ObjectUtils.isEmpty(userOrderPO)) {
            return ResultUtil.errorResult(ResultCode.PARAM_ERROR);
        }

        String shoppingCartNumbers = userOrderPO.getShoppingCartNumbers();
        if (ObjectUtils.isEmpty(shoppingCartNumbers)) {
            return ResultUtil.errorResult(ResultCode.PARAM_ERROR);
        }

        UserOrderDO userOrderDO = ObjectCopyUtil.copyObject(userOrderPO, UserOrderDO.class);
        if (ObjectUtils.isEmpty(userOrderDO)) {
            return ResultUtil.errorResult(ResultCode.OBJECT_COPY_FAILED);
        } else {
            String[] shoppingCartNumberArray = shoppingCartNumbers.split(Constant.SPLIT_STR_COMMA);

            if (shoppingCartNumberArray.length > 0) {
                HttpSession httpSession = httpServletRequest.getSession();
                Integer userId = Integer.parseInt((String) httpSession.getAttribute(Constant.USER_ID));

                if (ObjectUtils.isEmpty(userId)) {
                    return ResultUtil.errorResult(ResultCode.NO_LOGIN);
                } else {
                    Date now = DateUtil.now();
                    String nowStr = DateUtil.dateToString(now, DateConstant.yyyyMMddHHmmss);
                    String number = Constant.PREFIX_ORDER + nowStr + MemoryData.getNumberSuffix();

                    double totalMoney = shoppingCartDAO.selectTotalMoneyByShoppingCartNumber(shoppingCartNumberArray);

                    userOrderDO.setGmtCreate(now);
                    userOrderDO.setGmtModify(now);
                    userOrderDO.setNumber(number);
                    userOrderDO.setShoppingCartNumbers(shoppingCartNumbers);
                    userOrderDO.setStatus(UserOrderStatus.NO_PAY.getCode());
                    userOrderDO.setTotalPrice(new BigDecimal(totalMoney));
                    userOrderDO.setUserId(userId);

                    userOrderDAO.insertSelective(userOrderDO);

                    //批量更新购物车记录的状态：未下单 -> 已下单
                    shoppingCartDAO.updateBatchStatusByNumber(shoppingCartNumberArray, ShoppingCartStatus.ORDERED.getCode());

                    return ResultUtil.successResult(TrueOrFalse.getTrue());
                }
            } else {
                return ResultUtil.errorResult(ResultCode.PARAM_ERROR);
            }
        }
    }

}
