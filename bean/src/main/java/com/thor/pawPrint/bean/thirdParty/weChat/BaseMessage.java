package com.thor.pawPrint.bean.thirdParty.weChat;

import lombok.Data;

import java.io.Serializable;

/**
 * 微信消息基类
 * Created by Thor on 2017/2/8.
 * happy coding - 1203!
 */
@Data
public class BaseMessage implements Serializable {
    //开发者微信号
    private String ToUserName;

    //发送方帐号（一个OpenID）
    private String FromUserName;

    //消息创建时间（整型）
    private String CreateTime;

    //消息类型（text/image/location/link）
    private String MsgType;

}
