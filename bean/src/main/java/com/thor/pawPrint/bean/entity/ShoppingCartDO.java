package com.thor.pawPrint.bean.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ShoppingCartDO implements Serializable {
    private Integer id;

    private Date gmtCreate;

    private Date gmtModify;

    private String number;

    private Integer userId;

    private Integer goodsId;

    private Integer num;

    private BigDecimal unitPrice;

    private BigDecimal totalPrice;

    private String status;

}