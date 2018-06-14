package com.thor.pawPrint.web.system.task.system;

import com.thor.pawPrint.biz.controller.weChat.WeChatBiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 开启服务需要执行的任务
 * Created by Thor on 2017/2/7.
 * happy coding - 1203!
 */
@Component
@Slf4j
public class StartApplicationTask implements CommandLineRunner {
    @Autowired
    private WeChatBiz weChatBiz;

    @Override
    public void run(String... strings) throws Exception {
        log.info("StartApplicationTask");

        weChatBiz.getAccessToken();
    }

}
