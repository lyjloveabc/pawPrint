package com.thor.pawPrint.bean.thirdParty.weChat.receiveMessage.ordinaryMessage.type;

import com.thor.pawPrint.bean.thirdParty.weChat.receiveMessage.ordinaryMessage.BaseOrdinaryReceiveMessage;
import lombok.Data;

import java.io.Serializable;

/**
 * 文本消息
 * Created by Thor on 2017/2/8.
 * happy coding - 1203!
 */
@Data
public class TextReceiveMessage extends BaseOrdinaryReceiveMessage implements Serializable {
    //文本消息内容
    private String Content;

}
