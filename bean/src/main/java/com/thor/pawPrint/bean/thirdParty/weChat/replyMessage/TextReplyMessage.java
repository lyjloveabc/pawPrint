package com.thor.pawPrint.bean.thirdParty.weChat.replyMessage;

import com.thor.pawPrint.bean.thirdParty.weChat.BaseMessage;
import lombok.Data;

/**
 * 文本消息
 * Created by Thor on 2017/2/8.
 * happy coding - 1203!
 */
@Data
public class TextReplyMessage extends BaseMessage {
    //是 回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
    private String Content;

}
