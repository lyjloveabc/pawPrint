package com.thor.pawPrint.bean.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class WeChatConfigDO implements Serializable {
    private Integer id;

    private Date gmtCreate;

    private Date gmtModify;

    private String appId;

    private String appSecret;

    private String url;

    private String token;

    private String encodingAesKey;

    private String accessToken;

    private String isUsing;

}