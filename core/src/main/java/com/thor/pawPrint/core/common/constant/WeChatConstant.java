package com.thor.pawPrint.core.common.constant;

/**
 * 微信常量
 * Created by Thor on 2017/2/7.
 * happy coding - 1203!
 */
public interface WeChatConstant {
    //**************************************** 接口URL ****************************************//
    String GET_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
    String GET_USER_INFO = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s&lang=zh_CN";
    String GET_OPEN_ID_BY_CODE = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";

    //**************************************** 接口返回参数 ****************************************//
    String ACCESS_TOKEN = "access_token";
    String SIGNATURE = "signature";
    String TIMESTAMP = "timestamp";
    String NONCE = "nonce";
    String ECHOSTR = "echostr";
    String CODE = "code";
    String OPEN_ID = "openId";

    //**************************************** 接口返回参数 ****************************************//
    Long ACCESS_TOKEN_FAILURE_TIME = 3600000L;

    //**************************************** 微信消息类型 ****************************************//
    String MSG_TYPE_TEXT = "text";
    String MSG_TYPE_IMAGE = "image";
    String MSG_TYPE_VOICE = "voice";
    String MSG_TYPE_VIDEO = "video";
    String MSG_TYPE_SHORT_VIDEO = "shortvideo";
    String MSG_TYPE_LOCATION = "location";
    String MSG_TYPE_LINK = "link";
    String MSG_TYPE_EVENT = "event";

    //**************************************** 微信事件消息的事件类型类型 ****************************************//
    String EVENT_TYPE_SUBSCRIBE = "subscribe";
    String EVENT_TYPE_UN_SUBSCRIBE = "unsubscribe";
    String EVENT_TYPE_SCAN = "SCAN";
    String EVENT_TYPE_LOCATION = "LOCATION";
    String EVENT_TYPE_CLICK = "CLICK";
    String EVENT_TYPE_VIEW = "VIEW";

    //**************************************** 接口返回XML属性 ****************************************//
    String XML_TO_USER_NAME = "ToUserName";
    String XML_FROM_USER_NAME = "FromUserName";
    String XML_CREATE_TIME = "CreateTime";
    String XML_MSG_TYPE = "MsgType";
    String XML_MSG_ID = "MsgId";
    String XML_CONTENT = "Content";
    String XML_PIC_URL = "PicUrl";
    String XML_MEDIA_ID = "MediaId";
    String XML_FORMAT = "Format";
    String XML_THUMB_MEDIA_ID = "ThumbMediaId";
    String XML_LOCATION_X = "Location_X";
    String XML_LOCATION_Y = "Location_Y";
    String XML_SCALE = "Scale";
    String XML_LABEL = "Label";
    String XML_TITLE = "Title";
    String XML_DESCRIPTION = "Description";
    String XML_URL = "Url";
    String XML_EVENT = "Event";
    String XML_EVENT_KEY = "EventKey";
    String XML_TICKET = "Ticket";
    String XML_LATITUDE = "Latitude";
    String XML_LONGITUDE = "Longitude";
    String XML_PRECISION = "Precision";

}
