package com.thor.pawPrint.web.system.task.system;

import com.thor.pawPrint.bean.entity.WeChatConfigDO;
import com.thor.pawPrint.core.common.constant.WeChatConstant;
import com.thor.pawPrint.core.common.result.ResultCode;
import com.thor.pawPrint.core.utils.data.DateUtil;
import com.thor.pawPrint.core.utils.data.GsonUtil;
import com.thor.pawPrint.dao.daoTemp.WeChatConfigDAO;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

/**
 * 微信相关的定时任务
 * Created by Thor on 2017/2/10.
 * happy coding - 1203!
 */
@Component
@Slf4j
public class WeChatTask {
    @Autowired
    private WeChatConfigDAO weChatConfigDAO;

    /**
     * 刷新accessToken，每隔1小时获取accessToken，更新到数据库
     */
    @Scheduled(cron = "0 0 0/1 * * ?")
    @Transactional
    public void refreshAccessToken() throws Exception {
        log.info("start refreshAccessToken ……");

        //获取当前使用的微信配置
        WeChatConfigDO weChatConfigIsUsing = weChatConfigDAO.selectIsUsing();

        if (ObjectUtils.isEmpty(weChatConfigIsUsing)) {
            log.error(ResultCode.NO_IS_USING_WE_CHAT_CONFIG.getMessage());
        } else {
            String appId = weChatConfigIsUsing.getAppId();
            String appSecret = weChatConfigIsUsing.getAppSecret();

            //通过微信服务器获取accessToken
            String url = String.format(WeChatConstant.GET_ACCESS_TOKEN, appId, appSecret);
            OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
            Request request = new Request.Builder().url(url).build();
            Response response = okHttpClient.newCall(request).execute();

            ResponseBody responseBody = response.body();
            String accessToken = GsonUtil.getNodeStringValueGson(responseBody.string(), WeChatConstant.ACCESS_TOKEN);

            //更新数据库字段
            if (ObjectUtils.isEmpty(accessToken)) {
                log.error(ResultCode.GET_ACCESS_TOKEN_FAILED.getMessage());
            } else {
                WeChatConfigDO weChatConfigNew = new WeChatConfigDO();
                weChatConfigNew.setGmtModify(DateUtil.now());
                weChatConfigNew.setAccessToken(accessToken);
                weChatConfigDAO.updateByPrimaryKeySelective(weChatConfigNew);
            }
        }
    }
}
