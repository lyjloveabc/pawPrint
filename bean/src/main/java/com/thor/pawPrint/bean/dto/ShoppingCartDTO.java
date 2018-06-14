package com.thor.pawPrint.bean.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Thor on 2017/2/14.
 * happy coding - 1203!
 */
@Data
public class ShoppingCartDTO implements Serializable{
    private Integer id;

    private String number;

    private Integer userId;

    private Integer goodsId;

    private Integer num;

    private BigDecimal unitPrice;

    private BigDecimal totalPrice;

    private String status;

}
