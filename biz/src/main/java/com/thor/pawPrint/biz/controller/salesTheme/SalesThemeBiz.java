package com.thor.pawPrint.biz.controller.salesTheme;

import com.thor.pawPrint.bean.dto.SalesThemeDTO;
import com.thor.pawPrint.core.common.result.Result;

import java.util.List;

/**
 * Created by Thor on 2017/2/14.
 * happy coding - 1203!
 */
public interface SalesThemeBiz {
    /**
     * 获取所有已经上架的销售主题
     *
     * @return 所有已经上架的销售主题
     */
    Result<List<SalesThemeDTO>> allShelvesSalesTheme();

}
