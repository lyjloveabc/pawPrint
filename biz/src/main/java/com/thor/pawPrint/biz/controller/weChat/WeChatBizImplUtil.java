package com.thor.pawPrint.biz.controller.weChat;

import com.google.common.collect.Maps;
import com.thor.pawPrint.bean.entity.UserDO;
import com.thor.pawPrint.bean.thirdParty.weChat.BaseMessage;
import com.thor.pawPrint.bean.thirdParty.weChat.receiveMessage.ordinaryMessage.type.TextReceiveMessage;
import com.thor.pawPrint.bean.thirdParty.weChat.replyMessage.TextReplyMessage;
import com.thor.pawPrint.core.common.constant.Constant;
import com.thor.pawPrint.core.common.constant.WeChatConstant;
import com.thor.pawPrint.core.common.result.Result;
import com.thor.pawPrint.core.utils.data.DateUtil;
import com.thor.pawPrint.core.utils.data.GsonUtil;
import com.thor.pawPrint.core.utils.object.ObjectTransformUtil;
import com.thoughtworks.xstream.XStream;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * WeChatBizImpl的静态方法，主要是方法太多，单独拉出来，容易查看
 * Created by Thor on 2017/2/10.
 * happy coding - 1203!
 */
@Slf4j
public class WeChatBizImplUtil {

    /**
     * 从请求xml的map中获取baseMessage对象信息
     *
     * @param requestXmlMap 求xml的map
     * @return BaseMessage对象
     */
    static BaseMessage getBaseMessageFromRequestXmlMap(Map<String, String> requestXmlMap) {
        //开发者微信号
        String toUserName = requestXmlMap.get(WeChatConstant.XML_TO_USER_NAME);
        //发送方帐号
        String fromUserName = requestXmlMap.get(WeChatConstant.XML_FROM_USER_NAME);
        //消息创建时间 （整型）
        String createTime = requestXmlMap.get(WeChatConstant.XML_CREATE_TIME);
        //消息类型
        String msgType = requestXmlMap.get(WeChatConstant.XML_MSG_TYPE);

        BaseMessage baseMessage = new BaseMessage();
        baseMessage.setCreateTime(createTime);
        baseMessage.setFromUserName(fromUserName);
        baseMessage.setMsgType(msgType);
        baseMessage.setToUserName(toUserName);

        return baseMessage;
    }

    /**
     * 微信回复-文本信息
     *
     * @param baseMessage baseMessage
     * @param content     content
     * @return 文本信息xml
     */
    static String replyTextMessage(BaseMessage baseMessage, String content) {
        TextReplyMessage textReplyMessage = new TextReplyMessage();
        textReplyMessage.setContent(content + " from Thor!");
        textReplyMessage.setCreateTime(String.valueOf(DateUtil.getTimestamp()));
        textReplyMessage.setFromUserName(baseMessage.getToUserName());
        textReplyMessage.setMsgType(WeChatConstant.MSG_TYPE_TEXT);
        textReplyMessage.setToUserName(baseMessage.getFromUserName());

        XStream xStream = new XStream();
        xStream.alias(Constant.DATA_XML, TextReplyMessage.class);

        return xStream.toXML(textReplyMessage);
    }


    public static void main(String[] args) {
        Map<String, String> map = Maps.newHashMap();
        map.put(WeChatConstant.XML_CONTENT, "测试");
        TextReceiveMessage textReceiveMessage = ObjectTransformUtil.mapToBean(map, TextReceiveMessage.class);
        System.out.println(textReceiveMessage);
    }
}
