package com.thor.pawPrint.web.system.interceptor;

import com.google.common.collect.Sets;
import com.thor.pawPrint.bean.entity.UserDO;
import com.thor.pawPrint.bean.entity.WeChatConfigDO;
import com.thor.pawPrint.bean.param.weChat.GetOpenIdByCodePO;
import com.thor.pawPrint.core.common.constant.BeanVariable;
import com.thor.pawPrint.core.common.constant.Constant;
import com.thor.pawPrint.core.common.constant.WeChatConstant;
import com.thor.pawPrint.core.utils.data.GsonUtil;
import com.thor.pawPrint.core.utils.object.ValidationUtil;
import com.thor.pawPrint.dao.daoTemp.UserDAO;
import com.thor.pawPrint.dao.daoTemp.WeChatConfigDAO;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 微信用户访问本网站，获取他的openId，存到session中
 * Created by Thor on 2017/2/18.
 * happy coding - 1203!
 */
@Slf4j
public class OpenIdInterceptor implements HandlerInterceptor {
    @Autowired
    private WeChatConfigDAO weChatConfigDAO;

    @Autowired
    private UserDAO userDAO;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession httpSession = httpServletRequest.getSession();
        httpSession.setAttribute(Constant.USER_ID, "1");//测试使用
        return true;
        /*String userId = (String) httpSession.getAttribute(Constant.USER_ID);

        WeChatConfigDO weChatConfigDO = weChatConfigDAO.selectIsUsing();

        if (!ValidationUtil.checkParamAttributeEmpty(weChatConfigDO, Sets.newHashSet(BeanVariable.ACCESS_TOKEN))) {
            if (ObjectUtils.isEmpty(userId)) {
                String appId = weChatConfigDO.getAppId();
                String appSecret = weChatConfigDO.getAppSecret();
                String code = httpServletRequest.getParameter(WeChatConstant.CODE);

                String url = String.format(WeChatConstant.GET_OPEN_ID_BY_CODE, appId, appSecret, code);
                OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

                Request request = new Request.Builder().url(url).build();
                try {
                    Response response = okHttpClient.newCall(request).execute();
                    ResponseBody responseBody = response.body();
                    String responseBodyString = responseBody.string();

                    log.info("GET_OPEN_ID_BY_CODE: {}", responseBodyString);

                    GetOpenIdByCodePO getOpenIdByCodePO = GsonUtil.fromJsonGson(responseBodyString, GetOpenIdByCodePO.class);
                    String openId = getOpenIdByCodePO.getOpenid();
                    UserDO userDO = userDAO.selectByOpenId(openId);
                    if (!ObjectUtils.isEmpty(userDO)) {
                        httpSession.setAttribute(Constant.USER_ID, userDO.getId());
                    }

                } catch (IOException e) {
                    log.error("获取openId失败");
                    e.printStackTrace();
                }
            }
        }

        userId = (String) httpSession.getAttribute(Constant.USER_ID);
        return !ObjectUtils.isEmpty(userId);*/
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}
