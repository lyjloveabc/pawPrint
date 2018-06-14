package com.thor.pawPrint.bean.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Thor on 2017/2/14.
 * happy coding - 1203!
 */
@Data
public class GoodsDTO implements Serializable {
    private Integer id;

    private String code;

    private String chineseName;

    private String englishName;

    private String latinName;

    private String salesName;

    private String origin;

    private String color;

    private String branchesLength;

    private BigDecimal unitPrice;

    private String specs;

    private Integer inventory;

    private String isShelves;

    private String countryOfOrigin;

    private String distribution;

    private String otherName;

    private String curingDescription;

    private String distributionDescription;

    private String images;

    private String[] imageArray;

}
