package com.thor.pawPrint.biz.controller.weChat;

import com.google.common.collect.Maps;
import com.thor.pawPrint.bean.entity.UserDO;
import com.thor.pawPrint.bean.entity.WeChatConfigDO;
import com.thor.pawPrint.bean.param.UserPO;
import com.thor.pawPrint.bean.thirdParty.weChat.BaseMessage;
import com.thor.pawPrint.bean.thirdParty.weChat.receiveMessage.ordinaryMessage.type.*;
import com.thor.pawPrint.bean.thirdParty.weChat.replyMessage.TextReplyMessage;
import com.thor.pawPrint.core.common.constant.Constant;
import com.thor.pawPrint.core.common.constant.WeChatConstant;
import com.thor.pawPrint.core.common.result.Result;
import com.thor.pawPrint.core.common.result.ResultCode;
import com.thor.pawPrint.core.utils.data.DateUtil;
import com.thor.pawPrint.core.utils.data.GsonUtil;
import com.thor.pawPrint.core.utils.data.RandomUtil;
import com.thor.pawPrint.core.utils.net.RequestUtil;
import com.thor.pawPrint.core.utils.object.ObjectTransformUtil;
import com.thor.pawPrint.core.utils.system.ResultUtil;
import com.thor.pawPrint.core.utils.thirdParty.WeChatUtil;
import com.thor.pawPrint.dao.daoTemp.UserDAO;
import com.thor.pawPrint.dao.daoTemp.WeChatConfigDAO;
import com.thoughtworks.xstream.XStream;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */
@Service
@Slf4j
public class WeChatBizImpl implements WeChatBiz {
    @Autowired
    private WeChatConfigDAO weChatConfigDAO;

    @Autowired
    private UserDAO userDAO;

    @Override
    public String check(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws NoSuchAlgorithmException {
        String result;

        //提取字段
        String signature = httpServletRequest.getParameter(WeChatConstant.SIGNATURE);
        String timestamp = httpServletRequest.getParameter(WeChatConstant.TIMESTAMP);
        String nonce = httpServletRequest.getParameter(WeChatConstant.NONCE);
        String echostr = httpServletRequest.getParameter(WeChatConstant.ECHOSTR);

        WeChatConfigDO weChatConfigDO = weChatConfigDAO.selectIsUsing();
        if (ObjectUtils.isEmpty(weChatConfigDO)) {
            result = ResultCode.NO_IS_USING_WE_CHAT_CONFIG.getMessage();
        } else {
            String token = weChatConfigDO.getToken();
            if (ObjectUtils.isEmpty(token)) {
                result = ResultCode.WE_CHAT_CONFIG_NO_TOKEN.getMessage();
            } else {
                if (WeChatUtil.checkSignature(signature, token, timestamp, nonce)) {
                    result = echostr;
                } else {
                    result = ResultCode.CHECK_SIGNATURE_FAILED.getMessage();
                }
            }
        }

        return result;
    }

    @Override
    public String handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException, DocumentException, NoSuchAlgorithmException {
        //最终响应
        String result;

        //提取字段
        String signature = httpServletRequest.getParameter(WeChatConstant.SIGNATURE);
        String timestamp = httpServletRequest.getParameter(WeChatConstant.TIMESTAMP);
        String nonce = httpServletRequest.getParameter(WeChatConstant.NONCE);

        //WeChatConfigDO weChatConfigDO = weChatConfigDAO.selectIsUsing();
        //if (!ValidationUtil.checkParamAttributeEmpty(weChatConfigDO, Sets.newHashSet(BeanVariable.ACCESS_TOKEN))
        //**************************************** test ****************************************//
        WeChatConfigDO weChatConfigDO = new WeChatConfigDO();
        weChatConfigDO.setToken("Thor");
            weChatConfigDO.setAccessToken("DV0JsK1A_jod45Q3kKRsCqZIq9LQuF9WG6gtw8nV1gGM3vL3VGANx6EVfumYIwO0wgSwwWDA2VI3Hxw3Ebw9geU3A1pJ4uJIIPbw-jht6JjKz9slxoQO6ljPTk45by04PWUcACAELJ");

        String accessToken = weChatConfigDO.getAccessToken();

        if (WeChatUtil.checkSignature(signature, weChatConfigDO.getToken(), timestamp, nonce)) {
            Map<String, String> requestXmlMap = RequestUtil.requestToXml(httpServletRequest);
            log.info(GsonUtil.toJsonGson(requestXmlMap));

            //开发者微信号
            String toUserName = requestXmlMap.get(WeChatConstant.XML_TO_USER_NAME);
            //发送方帐号
            String fromUserName = requestXmlMap.get(WeChatConstant.XML_FROM_USER_NAME);
            //消息创建时间 （整型）
            String createTime = requestXmlMap.get(WeChatConstant.XML_CREATE_TIME);
            //消息类型
            String msgType = requestXmlMap.get(WeChatConstant.XML_MSG_TYPE);

            switch (msgType) {
                case WeChatConstant.MSG_TYPE_TEXT:
                    TextReceiveMessage textReceiveMessage = ObjectTransformUtil.mapToBean(requestXmlMap, TextReceiveMessage.class);
                    result = "";//WeChatBizImplUtil.replyTextMessage(baseMessage, WeChatConstant.MSG_TYPE_TEXT + " " + requestXmlMap.get(WeChatConstant.XML_CONTENT));
                    break;
                case WeChatConstant.MSG_TYPE_IMAGE:
                    ImageReceiveMessage imageReceiveMessage = ObjectTransformUtil.mapToBean(requestXmlMap, ImageReceiveMessage.class);
                    result = "";//WeChatBizImplUtil.replyTextMessage(baseMessage, WeChatConstant.MSG_TYPE_IMAGE + " " + String.valueOf(RandomUtil.get()));
                    break;
                case WeChatConstant.MSG_TYPE_VOICE:
                    VoiceReceiveMessage voiceReceiveMessage = ObjectTransformUtil.mapToBean(requestXmlMap, VoiceReceiveMessage.class);
                    result = "";//WeChatBizImplUtil.replyTextMessage(baseMessage, WeChatConstant.MSG_TYPE_VOICE + " " + String.valueOf(RandomUtil.get()));
                    break;
                case WeChatConstant.MSG_TYPE_VIDEO:
                    VideoReceiveMessage videoReceiveMessage = ObjectTransformUtil.mapToBean(requestXmlMap, VideoReceiveMessage.class);
                    result = "";// WeChatBizImplUtil.replyTextMessage(baseMessage, WeChatConstant.MSG_TYPE_VIDEO + " " + String.valueOf(RandomUtil.get()));
                    break;
                case WeChatConstant.MSG_TYPE_SHORT_VIDEO:
                    ShortVideoReceiveMessage shortVideoReceiveMessage = ObjectTransformUtil.mapToBean(requestXmlMap, ShortVideoReceiveMessage.class);
                    result = "";//WeChatBizImplUtil.replyTextMessage(baseMessage, WeChatConstant.MSG_TYPE_SHORT_VIDEO + " " + String.valueOf(RandomUtil.get()));
                    break;
                case WeChatConstant.MSG_TYPE_LOCATION:
                    LocationReceiveMessage locationReceiveMessage = ObjectTransformUtil.mapToBean(requestXmlMap, LocationReceiveMessage.class);
                    result = "";//WeChatBizImplUtil.replyTextMessage(baseMessage, WeChatConstant.MSG_TYPE_LOCATION + " " + String.valueOf(RandomUtil.get()));
                    break;
                case WeChatConstant.MSG_TYPE_LINK:
                    LinkReceiveMessage linkReceiveMessage = ObjectTransformUtil.mapToBean(requestXmlMap, LinkReceiveMessage.class);
                    result = "";//WeChatBizImplUtil.replyTextMessage(baseMessage, WeChatConstant.MSG_TYPE_LINK + " " + String.valueOf(RandomUtil.get()));
                    break;
                case WeChatConstant.MSG_TYPE_EVENT:
                    //事件类型
                    String eventType = requestXmlMap.get(WeChatConstant.XML_EVENT);
                    switch (eventType) {
                        case WeChatConstant.EVENT_TYPE_SUBSCRIBE:
                            /* 关注公众号 */
                            result = toHandleEventSubscribe(accessToken, fromUserName);
                            break;
                        case WeChatConstant.EVENT_TYPE_UN_SUBSCRIBE:
                            /* 取消关注公众号 */
                            result = toHandleEventUnSubscribe(fromUserName);
                            break;
                        case WeChatConstant.EVENT_TYPE_LOCATION:
                            result = "EVENT_TYPE_LOCATION";
                            break;
                        default:
                            result = "MSG_TYPE_EVENT";
                            break;
                    }
                    break;
                default:
                    result = "";//WeChatBizImplUtil.replyTextMessage(baseMessage, "default " + String.valueOf(RandomUtil.get()));
                    break;
            }
        } else {
            result = ResultCode.CHECK_SIGNATURE_FAILED.getMessage();
        }

        return result;
    }

    @Override
    public Result<String> getAccessToken() throws IOException {
        //获取当前使用的微信配置
        WeChatConfigDO weChatConfigIsUsing = weChatConfigDAO.selectIsUsing();

        if (ObjectUtils.isEmpty(weChatConfigIsUsing)) {
            return ResultUtil.errorResult(ResultCode.NO_IS_USING_WE_CHAT_CONFIG);
        } else {
            Date now = DateUtil.now();

            Date modifyData = weChatConfigIsUsing.getGmtModify();
            String accessToken = weChatConfigIsUsing.getAccessToken();

            if (ObjectUtils.isEmpty(accessToken) || now.getTime() - modifyData.getTime() >= WeChatConstant.ACCESS_TOKEN_FAILURE_TIME) {
                String appId = weChatConfigIsUsing.getAppId();
                String appSecret = weChatConfigIsUsing.getAppSecret();

                //通过微信服务器获取accessToken
                String url = String.format(WeChatConstant.GET_ACCESS_TOKEN, appId, appSecret);
                OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
                Request request = new Request.Builder().url(url).build();
                Response response = okHttpClient.newCall(request).execute();

                ResponseBody responseBody = response.body();
                accessToken = GsonUtil.getNodeStringValueGson(responseBody.string(), WeChatConstant.ACCESS_TOKEN);

                //更新数据库字段
                if (ObjectUtils.isEmpty(accessToken)) {
                    return ResultUtil.errorResult(ResultCode.GET_ACCESS_TOKEN_FAILED);
                } else {
                    if (!accessToken.equals(weChatConfigIsUsing.getAccessToken())) {
                        WeChatConfigDO weChatConfigNew = new WeChatConfigDO();
                        weChatConfigNew.setGmtModify(DateUtil.now());
                        weChatConfigNew.setAccessToken(accessToken);
                        weChatConfigDAO.updateByPrimaryKeySelective(weChatConfigNew);
                    }

                    return ResultUtil.successResult(accessToken);
                }
            }

            return ResultUtil.successResult(accessToken);
        }
    }

    //关注公众号的处理逻辑
    private String toHandleEventSubscribe(String accessToken, String fromUserName) {
        //最终结果
        String result;

        if (ObjectUtils.isEmpty(fromUserName)) {
            return ResultCode.NO_OPEN_ID.getMessage();
        }

        Date now = DateUtil.now();

        //根据openId获取用户
        UserDO userDO = userDAO.selectByOpenId(fromUserName);
        if (ObjectUtils.isEmpty(userDO)) {
            userDO = new UserDO();
            userDO.setGmtCreate(now);
            userDO.setGmtModify(now);
            userDO.setOpenid(fromUserName);

            //新增用户
            userDAO.insertSelective(userDO);
        }

        //异步获取用户信息
        ExecutorService executorService = Executors.newFixedThreadPool(Constant.CORE_POOL_SIZE);
        executorService.execute(() -> {
            String url = String.format(WeChatConstant.GET_USER_INFO, accessToken, fromUserName);
            OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

            Request request = new Request.Builder().url(url).build();
            try {
                Response response = okHttpClient.newCall(request).execute();
                ResponseBody responseBody = response.body();
                String userInfo = responseBody.string();

                log.info("userInfo: {}", userInfo);

                UserDO userPO = GsonUtil.fromJsonGson(userInfo, UserDO.class);
                userDAO.updateByOpenIdSelective(userPO);
            } catch (IOException e) {
                log.error("异步获取用户信息失败，更新用户信息失败，openId={}", fromUserName);
                e.printStackTrace();
            }
        });
        executorService.shutdown();

        log.info("{} 关注了公众号！", fromUserName);
        result = "感谢您关注公众号！";

        return result;
    }

    //取消关注公众号的处理逻辑
    private String toHandleEventUnSubscribe(String fromUserName) {
        if (ObjectUtils.isEmpty(fromUserName)) {
            return ResultCode.NO_OPEN_ID.getMessage();
        }

        UserDO userDO = new UserDO();
        userDO.setOpenid(fromUserName);
        userDO.setGmtModify(DateUtil.now());
        userDAO.updateByOpenIdSelective(userDO);

        log.info("{} 取消关注了公众号！", fromUserName);

        return "您取消关注公众号！";
    }

}
