package com.thor.pawPrint.bean.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserDO implements Serializable {
    private Integer id;

    private Date gmtCreate;

    private Date gmtModify;

    private String subscribe;

    private String openid;

    private String nickname;

    private String sex;

    private String country;

    private String province;

    private String city;

    private String language;

    private String headimgurl;

    private String subscribeTime;

    private String unionid;

    private String remark;

    private String groupid;

    private String mobile;

    private String email;

    private Integer integral;

    private String flowerShopName;

    private String defaultShippingAddressName;

}