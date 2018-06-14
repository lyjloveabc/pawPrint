package com.thor.pawPrint.bean.thirdParty.weChat.receiveMessage.eventMessage.type;

import com.thor.pawPrint.bean.thirdParty.weChat.receiveMessage.eventMessage.BaseEventReceiveMessage;
import lombok.Data;

import java.io.Serializable;

/**
 * 扫描带参数二维码事件(关注和未关注是有区别的)
 * Created by Thor on 2017/2/8.
 * happy coding - 1203!
 */
@Data
public class ScanReceiveMessage extends BaseEventReceiveMessage implements Serializable {
    //事件KEY值，qrscene_为前缀，后面为二维码的参数值
    private String EventKey;

    //二维码的ticket，可用来换取二维码图片
    private String Ticket;

}
