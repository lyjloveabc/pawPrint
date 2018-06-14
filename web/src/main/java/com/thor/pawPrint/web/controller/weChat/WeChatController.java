package com.thor.pawPrint.web.controller.weChat;

import com.thor.pawPrint.biz.controller.weChat.WeChatBiz;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * 微信消息处理器
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */
@RestController
@RequestMapping("weChatMessage")
@Slf4j
public class WeChatController {
    @Autowired
    private WeChatBiz weChatBiz;

    /**
     * 微信验证服务器
     *
     * @param httpServletRequest  请求
     * @param httpServletResponse 响应
     * @return 字符串返回
     * @throws NoSuchAlgorithmException NoSuchAlgorithmException
     */
    @RequestMapping("check")
    public String check(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws NoSuchAlgorithmException {
        return weChatBiz.check(httpServletRequest, httpServletResponse);
    }

    /**
     * 处理微信转发过来的请求
     *
     * @param httpServletRequest  请求
     * @param httpServletResponse 响应
     * @return 响应XML
     * @throws IOException              IOException
     * @throws DocumentException        DocumentException
     * @throws NoSuchAlgorithmException NoSuchAlgorithmException
     */
    @RequestMapping("handle")
    public String handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException, DocumentException, NoSuchAlgorithmException {
        return weChatBiz.handle(httpServletRequest, httpServletResponse);
    }

}
