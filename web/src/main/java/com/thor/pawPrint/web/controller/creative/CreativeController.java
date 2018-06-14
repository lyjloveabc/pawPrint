package com.thor.pawPrint.web.controller.creative;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Thor on 2017/2/24.
 * happy coding - 1203!
 */
@Controller
@RequestMapping("creative")
@Slf4j
public class CreativeController {
    /**
     * 创意页
     *
     * @return ModelAndView
     */
    @RequestMapping("creativePage")
    public ModelAndView creativePage() {
        return new ModelAndView("weChat/creative/creative");
    }

}
