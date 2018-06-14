package com.thor.pawPrint.bean.thirdParty.weChat.receiveMessage.ordinaryMessage.type;

import com.thor.pawPrint.bean.thirdParty.weChat.receiveMessage.ordinaryMessage.BaseOrdinaryReceiveMessage;
import lombok.Data;

import java.io.Serializable;

/**
 * 图片消息
 * Created by Thor on 2017/2/8.
 * happy coding - 1203!
 */
@Data
public class ImageReceiveMessage extends BaseOrdinaryReceiveMessage implements Serializable {
    //图片链接（由系统生成）
    private String PicUrl;

    //图片消息媒体id，可以调用多媒体文件下载接口拉取数据
    private String MediaId;

}
