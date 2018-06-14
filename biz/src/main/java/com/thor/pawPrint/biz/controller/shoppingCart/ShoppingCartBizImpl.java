package com.thor.pawPrint.biz.controller.shoppingCart;

import com.google.common.collect.Lists;
import com.thor.pawPrint.bean.common.MemoryData;
import com.thor.pawPrint.bean.dto.ShoppingCartXGoodsDTO;
import com.thor.pawPrint.bean.dto.simple.TrueOrFalse;
import com.thor.pawPrint.bean.entity.GoodsDO;
import com.thor.pawPrint.bean.entity.ShoppingCartDO;
import com.thor.pawPrint.bean.enumBean.ShoppingCartStatus;
import com.thor.pawPrint.bean.param.ShoppingCartPO;
import com.thor.pawPrint.core.common.constant.Constant;
import com.thor.pawPrint.core.common.constant.DateConstant;
import com.thor.pawPrint.core.common.result.Result;
import com.thor.pawPrint.core.common.result.ResultCode;
import com.thor.pawPrint.core.utils.data.DateUtil;
import com.thor.pawPrint.core.utils.object.ObjectCopyUtil;
import com.thor.pawPrint.core.utils.system.ResultUtil;
import com.thor.pawPrint.core.utils.system.SystemUtil;
import com.thor.pawPrint.dao.daoTemp.GoodsDAO;
import com.thor.pawPrint.dao.daoTemp.ShoppingCartDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Thor on 2017/2/14.
 * happy coding - 1203!
 */
@Service
@Slf4j
public class ShoppingCartBizImpl implements ShoppingCartBiz {
    @Autowired
    private ShoppingCartDAO shoppingCartDAO;

    @Autowired
    private GoodsDAO goodsDAO;

    @Autowired
    private HttpServletRequest httpServletRequest;


    @Override
    public Result<TrueOrFalse> add(ShoppingCartPO shoppingCartPO) {
        if (ObjectUtils.isEmpty(shoppingCartPO)) {
            return ResultUtil.errorResult(ResultCode.PARAM_ERROR);
        }

        Integer goodsId = shoppingCartPO.getGoodsId();
        Integer num = shoppingCartPO.getNum();
        if (ObjectUtils.isEmpty(goodsId) || ObjectUtils.isEmpty(num)) {
            return ResultUtil.errorResult(ResultCode.PARAM_ERROR);
        }

        ShoppingCartDO shoppingCartDO = ObjectCopyUtil.copyObject(shoppingCartPO, ShoppingCartDO.class);
        if (ObjectUtils.isEmpty(shoppingCartDO)) {
            return ResultUtil.errorResult(ResultCode.OBJECT_COPY_FAILED);
        } else {
            HttpSession httpSession = httpServletRequest.getSession();
            Integer userId = Integer.parseInt((String) httpSession.getAttribute(Constant.USER_ID));

            if (ObjectUtils.isEmpty(userId)) {
                return ResultUtil.errorResult(ResultCode.NO_LOGIN);
            } else {
                Date now = DateUtil.now();
                String nowStr = DateUtil.dateToString(now, DateConstant.yyyyMMddHHmmss);
                String number = Constant.PREFIX_SHOPPING_CART + nowStr + MemoryData.getNumberSuffix();

                GoodsDO goodsDO = goodsDAO.selectByPrimaryKey(goodsId);
                if (ObjectUtils.isEmpty(goodsDO)) {
                    return ResultUtil.errorResult(ResultCode.PARAM_ERROR);
                } else {
                    BigDecimal unitPrice = goodsDO.getUnitPrice();

                    shoppingCartDO.setGmtCreate(now);
                    shoppingCartDO.setGmtModify(now);
                    shoppingCartDO.setNumber(number);
                    shoppingCartDO.setStatus(ShoppingCartStatus.NO_ORDER.getCode());
                    shoppingCartDO.setTotalPrice(unitPrice.multiply(new BigDecimal(num)));
                    shoppingCartDO.setUnitPrice(unitPrice);
                    shoppingCartDO.setUserId(userId);

                    shoppingCartDAO.insertSelective(shoppingCartDO);

                    return ResultUtil.successResult(TrueOrFalse.getTrue());
                }
            }
        }
    }

    @Override
    public Result<List<ShoppingCartXGoodsDTO>> userShoppingCarts() {
        HttpSession httpSession = httpServletRequest.getSession();
        Integer userId = Integer.parseInt((String) httpSession.getAttribute(Constant.USER_ID));

        if (ObjectUtils.isEmpty(userId)) {
            return ResultUtil.errorResult(ResultCode.NO_LOGIN);
        } else {
            List<ShoppingCartXGoodsDTO> result = Lists.newArrayList();

            List<ShoppingCartDO> shoppingCartDOs = shoppingCartDAO.selectByUserId(userId);

            for (ShoppingCartDO temp : shoppingCartDOs) {
                Integer goodsId = temp.getGoodsId();

                GoodsDO goodsDO = goodsDAO.selectByPrimaryKey(goodsId);

                ShoppingCartXGoodsDTO shoppingCartXGoodsDTO = new ShoppingCartXGoodsDTO();
                shoppingCartXGoodsDTO.setGoodsColor(goodsDO.getColor());
                shoppingCartXGoodsDTO.setGoodsId(goodsId);
                shoppingCartXGoodsDTO.setGoodsImg(SystemUtil.getGoodsMainImage(goodsDO.getImages()));
                shoppingCartXGoodsDTO.setGoodsSalesName(goodsDO.getSalesName());
                shoppingCartXGoodsDTO.setNum(temp.getNum());
                shoppingCartXGoodsDTO.setShoppingCartId(temp.getId());
                shoppingCartXGoodsDTO.setShoppingCartNumber(temp.getNumber());
                shoppingCartXGoodsDTO.setTotalPrice(temp.getTotalPrice());
                shoppingCartXGoodsDTO.setUnitPrice(temp.getUnitPrice());
                shoppingCartXGoodsDTO.setSpecs(goodsDO.getSpecs());

                result.add(shoppingCartXGoodsDTO);
            }

            return ResultUtil.successResult(result);
        }
    }

}
