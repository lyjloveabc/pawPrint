package com.thor.pawPrint.bean.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class UserOrderDO implements Serializable {
    private Integer id;

    private Date gmtCreate;

    private Date gmtModify;

    private String number;

    private Integer userId;

    private String shoppingCartNumbers;

    private BigDecimal totalPrice;

    private BigDecimal actualPaidMoney;

    private String payWay;

    private Date gmtPay;

    private String tradeNo;

    private String status;

}