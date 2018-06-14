package com.thor.pawPrint.web.controller.contactUs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 联系我们
 * Created by Thor on 2017/3/12.
 * happy coding - 1203!
 */
@Controller
@RequestMapping("contactUs")
@Slf4j
public class ContactUsController {
    /**
     * 联系我们页面
     *
     * @return ModelAndView
     */
    @RequestMapping("contactUsPage")
    public ModelAndView contactUsPage() {
        return new ModelAndView("weChat/contactUs/contactUs");
    }

}
