package com.thor.pawPrint.bean.param;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Thor on 2017/2/10.
 * happy coding - 1203!
 */
@Data
public class UserPO implements Serializable {
    private Integer id;

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
