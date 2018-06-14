package com.thor.pawPrint.bean.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SalesThemeDO implements Serializable {
    private Integer id;

    private Date gmtCreate;

    private Date gmtModify;

    private String code;

    private String salesName;

    private String image;

    private String goodsIds;

    private String isShelves;

}