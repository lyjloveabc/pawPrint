package com.thor.pawPrint.bean.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class GoodsDO implements Serializable {
    private Integer id;

    private Date gmtCreate;

    private Date gmtModify;

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

}