package com.thor.pawPrint.biz.controller.weChat;

import com.thor.pawPrint.core.common.result.Result;
import org.dom4j.DocumentException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */
public interface WeChatBiz {
    /**
     * 校验微信服务器
     *
     * @param httpServletRequest  请求
     * @param httpServletResponse 响应
     * @return 响应内容
     */
    String check(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws NoSuchAlgorithmException;

    /**
     * 处理微信消息
     *
     * @param httpServletRequest  请求
     * @param httpServletResponse 响应
     * @return 响应内容
     */
    String handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, DocumentException, NoSuchAlgorithmException;

    /**
     * 获取刷新accessToken（包括2各步骤：1、获取accessToken；2、更新数据库字段）
     *
     * @return accessToken
     * @throws IOException IOException
     */
    Result<String> getAccessToken() throws IOException;


}
