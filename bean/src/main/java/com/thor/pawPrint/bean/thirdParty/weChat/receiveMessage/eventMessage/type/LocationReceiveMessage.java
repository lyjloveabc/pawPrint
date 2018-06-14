package com.thor.pawPrint.bean.thirdParty.weChat.receiveMessage.eventMessage.type;

import com.thor.pawPrint.bean.thirdParty.weChat.receiveMessage.eventMessage.BaseEventReceiveMessage;
import lombok.Data;

import java.io.Serializable;

/**
 * 上报地理位置事件
 * Created by Thor on 2017/2/8.
 * happy coding - 1203!
 */
@Data
public class LocationReceiveMessage extends BaseEventReceiveMessage implements Serializable {
    //地理位置纬度
    private String Latitude;

    //地理位置经度
    private String Longitude;

    //地理位置精度
    private String Precision;

}
