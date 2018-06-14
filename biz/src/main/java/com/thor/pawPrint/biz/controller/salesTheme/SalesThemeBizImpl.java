package com.thor.pawPrint.biz.controller.salesTheme;

import com.thor.pawPrint.bean.dto.SalesThemeDTO;
import com.thor.pawPrint.bean.entity.SalesThemeDO;
import com.thor.pawPrint.core.common.result.Result;
import com.thor.pawPrint.core.utils.object.ObjectCopyUtil;
import com.thor.pawPrint.core.utils.system.ResultUtil;
import com.thor.pawPrint.dao.daoTemp.SalesThemeDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Thor on 2017/2/14.
 * happy coding - 1203!
 */
@Service
@Slf4j
public class SalesThemeBizImpl implements SalesThemeBiz {
    @Autowired
    private SalesThemeDAO salesThemeDAO;

    @Override
    public Result<List<SalesThemeDTO>> allShelvesSalesTheme() {
        List<SalesThemeDO> salesThemeDTOs = salesThemeDAO.selectAllShelvesSalesTheme();

        return ResultUtil.successResult(ObjectCopyUtil.copyObjects(salesThemeDTOs, SalesThemeDTO.class));
    }

}
