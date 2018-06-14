package com.thor.pawPrint.dao.mapper;

import com.thor.pawPrint.bean.entity.SalesThemeDO;
import com.thor.pawPrint.core.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SalesThemeDOMapper extends BaseMapper<SalesThemeDO> {
    /**
     * 获取所有已经上架的销售主题
     *
     * @return 所有已经上架的销售主题
     */
    List<SalesThemeDO> selectAllShelvesSalesTheme();

}