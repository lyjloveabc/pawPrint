package com.thor.pawPrint.bean.param;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Thor on 2017/2/14.
 * happy coding - 1203!
 */
@Data
public class ShoppingCartPO implements Serializable {
    private Integer goodsId;

    private Integer num;

}
