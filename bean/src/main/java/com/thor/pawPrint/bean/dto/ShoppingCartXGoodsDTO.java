package com.thor.pawPrint.bean.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Thor on 2017/2/20.
 * happy coding - 1203!
 */
@Data
public class ShoppingCartXGoodsDTO implements Serializable{
    private Integer shoppingCartId;

    private String shoppingCartNumber;

    private Integer goodsId;

    private Integer num;

    private BigDecimal unitPrice;

    private String specs;

    private BigDecimal totalPrice;

    private String goodsImg;

    private String goodsSalesName;

    private String goodsColor;

}
