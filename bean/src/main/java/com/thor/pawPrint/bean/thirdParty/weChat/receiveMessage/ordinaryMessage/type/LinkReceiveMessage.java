package com.thor.pawPrint.bean.thirdParty.weChat.receiveMessage.ordinaryMessage.type;

import com.thor.pawPrint.bean.thirdParty.weChat.receiveMessage.ordinaryMessage.BaseOrdinaryReceiveMessage;
import lombok.Data;

import java.io.Serializable;

/**
 * 链接消息
 * Created by Thor on 2017/2/8.
 * happy coding - 1203!
 */
@Data
public class LinkReceiveMessage extends BaseOrdinaryReceiveMessage implements Serializable {
    //消息标题
    private String Title;

    //消息描述
    private String Description;

    //消息链接
    private String Url;

}
