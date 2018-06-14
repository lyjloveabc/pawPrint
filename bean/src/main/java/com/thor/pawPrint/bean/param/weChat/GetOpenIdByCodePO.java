package com.thor.pawPrint.bean.param.weChat;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Thor on 2017/2/18.
 * happy coding - 1203!
 */
@Data
public class GetOpenIdByCodePO implements Serializable{
    String access_token;

    String expires_in;

    String refresh_token;

    String openid;

    String scope;

}
