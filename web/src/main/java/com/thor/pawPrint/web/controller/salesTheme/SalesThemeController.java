package com.thor.pawPrint.web.controller.salesTheme;

import com.thor.pawPrint.bean.dto.SalesThemeDTO;
import com.thor.pawPrint.biz.controller.salesTheme.SalesThemeBiz;
import com.thor.pawPrint.core.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 销售主题
 * Created by Thor on 2017/2/13.
 * happy coding - 1203!
 */
@Controller
@RequestMapping("salesTheme")
@Slf4j
public class SalesThemeController {
    @Autowired
    private SalesThemeBiz salesThemeBiz;

    /**
     * 销售主题页
     *
     * @return ModelAndView
     */
    @RequestMapping("salesThemePage")
    public ModelAndView salesThemePage() {
        return new ModelAndView("weChat/salesTheme/salesTheme");
    }

    /**
     * 获取所有已经上架的销售主题
     *
     * @return 所有已经上架的销售主题
     */
    @RequestMapping("allSalesTheme")
    @ResponseBody
    public Result<List<SalesThemeDTO>> allShelvesSalesTheme() {
        return salesThemeBiz.allShelvesSalesTheme();
    }

}
