package com.thor.pawPrint.web.controller.home;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 主页控制器
 * Created by Thor on 2017/2/9.
 * happy coding - 1203!
 */
@Controller
@RequestMapping("home")
@Slf4j
public class HomeController {
    /**
     * 首页
     *
     * @return ModelAndView
     */
    @RequestMapping("homePage")
    public ModelAndView homePage() {
        return new ModelAndView("weChat/home/home");
    }

}
