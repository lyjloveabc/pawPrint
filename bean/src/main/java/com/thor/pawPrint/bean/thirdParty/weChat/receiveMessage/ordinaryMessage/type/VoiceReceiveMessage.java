package com.thor.pawPrint.bean.thirdParty.weChat.receiveMessage.ordinaryMessage.type;

import com.thor.pawPrint.bean.thirdParty.weChat.receiveMessage.ordinaryMessage.BaseOrdinaryReceiveMessage;
import lombok.Data;

import java.io.Serializable;

/**
 * 语音消息
 * Created by Thor on 2017/2/8.
 * happy coding - 1203!
 */
@Data
public class VoiceReceiveMessage extends BaseOrdinaryReceiveMessage implements Serializable {

    //语音消息媒体id，可以调用多媒体文件下载接口拉取数据
    private String MediaId;

    //语音格式，如amr，speex等
    private String Format;

    /**
     * 请注意，开通语音识别后，用户每次发送语音给公众号时，微信会在推送的语音消息XML数据包中，
     * 增加一个Recongnition字段（注：由于客户端缓存，开发者开启或者关闭语音识别功能，
     * 对新关注者立刻生效，对已关注用户需要24小时生效。开发者可以重新关注此帐号进行测试）。
     * 开启语音识别后的语音XML数据包多了下面这个字段
     */
    //语音识别结果，UTF8编码
    private String Recognition;

}
