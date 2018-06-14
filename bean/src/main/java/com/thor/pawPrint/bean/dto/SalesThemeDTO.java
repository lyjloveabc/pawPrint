package com.thor.pawPrint.bean.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Thor on 2017/2/14.
 * happy coding - 1203!
 */
@Data
public class SalesThemeDTO implements Serializable{
    private Integer id;

    private String code;

    private String salesName;

    private String image;

    private String goodsIds;

    private String isShelves;

}
