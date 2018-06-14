package com.thor.pawPrint.bean.thirdParty.weChat.receiveMessage.ordinaryMessage.type;

import com.thor.pawPrint.bean.thirdParty.weChat.receiveMessage.ordinaryMessage.BaseOrdinaryReceiveMessage;
import lombok.Data;

import java.io.Serializable;

/**
 * 地理位置消息
 * Created by Thor on 2017/2/8.
 * happy coding - 1203!
 */
@Data
public class LocationReceiveMessage extends BaseOrdinaryReceiveMessage implements Serializable {
    //地理位置维度
    private String Location_X;

    //地理位置经度
    private String Location_Y;

    //地图缩放大小
    private String Scale;

    //地理位置信息
    private String Label;

}
