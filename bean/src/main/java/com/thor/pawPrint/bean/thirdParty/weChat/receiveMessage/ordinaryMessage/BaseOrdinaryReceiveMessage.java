package com.thor.pawPrint.bean.thirdParty.weChat.receiveMessage.ordinaryMessage;

import com.thor.pawPrint.bean.thirdParty.weChat.BaseMessage;
import lombok.Data;

import java.io.Serializable;

/**
 * 微信普通消息基类
 * Created by Thor on 2017/2/8.
 * happy coding - 1203!
 */
@Data
public class BaseOrdinaryReceiveMessage extends BaseMessage implements Serializable {
    //消息id，64位整型
    private String MsgId;

}
