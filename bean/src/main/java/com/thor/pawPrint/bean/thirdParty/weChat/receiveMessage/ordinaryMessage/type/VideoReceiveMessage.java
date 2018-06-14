package com.thor.pawPrint.bean.thirdParty.weChat.receiveMessage.ordinaryMessage.type;

import com.thor.pawPrint.bean.thirdParty.weChat.receiveMessage.ordinaryMessage.BaseOrdinaryReceiveMessage;
import lombok.Data;

import java.io.Serializable;

/**
 * 视频消息
 * Created by Thor on 2017/2/8.
 * happy coding - 1203!
 */
@Data
public class VideoReceiveMessage extends BaseOrdinaryReceiveMessage implements Serializable {
    //视频消息媒体id，可以调用多媒体文件下载接口拉取数据
    private String MediaId;

    //视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据
    private String ThumbMediaId;

}
