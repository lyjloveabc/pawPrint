package com.thor.pawPrint.bean.thirdParty.weChat.receiveMessage.eventMessage;

import com.thor.pawPrint.bean.thirdParty.weChat.BaseMessage;
import lombok.Data;

import java.io.Serializable;

/**
 * 微信事件消息基类
 * Created by Thor on 2017/2/8.
 * happy coding - 1203!
 */
@Data
public class BaseEventReceiveMessage extends BaseMessage implements Serializable {
    //事件类型
    private String Event;

}
