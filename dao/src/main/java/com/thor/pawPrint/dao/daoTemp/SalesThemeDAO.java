package com.thor.pawPrint.dao.daoTemp;

import com.thor.pawPrint.bean.entity.SalesThemeDO;
import com.thor.pawPrint.core.base.BaseDAO;
import com.thor.pawPrint.dao.mapper.SalesThemeDOMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Thor on 2017/2/13.
 * happy coding - 1203!
 */
@Component
public class SalesThemeDAO extends BaseDAO<SalesThemeDO, SalesThemeDOMapper> {
    /**
     * 获取所有已经上架的销售主题
     *
     * @return 所有已经上架的销售主题
     */
    public List<SalesThemeDO> selectAllShelvesSalesTheme() {
        return this.mapper.selectAllShelvesSalesTheme();
    }

}
