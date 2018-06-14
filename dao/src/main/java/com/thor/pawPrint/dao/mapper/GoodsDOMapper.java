package com.thor.pawPrint.dao.mapper;

import com.thor.pawPrint.bean.entity.GoodsDO;
import com.thor.pawPrint.core.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsDOMapper extends BaseMapper<GoodsDO> {
    /**
     * 根据商品ID集合，获取商品
     *
     * @param ids 商品ID结合
     * @return 商品列表
     */
    List<GoodsDO> selectBatchByPrimaryKey(@Param("ids") List<Integer> ids);

}