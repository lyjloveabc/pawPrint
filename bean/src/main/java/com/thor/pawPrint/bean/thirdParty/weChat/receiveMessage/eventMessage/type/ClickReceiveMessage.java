package com.thor.pawPrint.bean.thirdParty.weChat.receiveMessage.eventMessage.type;

import com.thor.pawPrint.bean.thirdParty.weChat.receiveMessage.eventMessage.BaseEventReceiveMessage;

import java.io.Serializable;

/**
 * 自定义菜单事件
 * Created by Thor on 2017/2/8.
 * happy coding - 1203!
 */
public class ClickReceiveMessage extends BaseEventReceiveMessage implements Serializable {
    //事件KEY值，与自定义菜单接口中KEY值对应
    private String EventKey;

}
