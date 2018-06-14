package com.thor.pawPrint.dao.daoTemp;

import com.thor.pawPrint.bean.entity.GoodsDO;
import com.thor.pawPrint.core.base.BaseDAO;
import com.thor.pawPrint.dao.mapper.GoodsDOMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Thor on 2017/2/13.
 * happy coding - 1203!
 */
@Component
public class GoodsDAO extends BaseDAO<GoodsDO, GoodsDOMapper> {
    /**
     * 根据商品ID集合，获取商品
     *
     * @param ids 商品ID结合
     * @return 商品列表
     */
    public List<GoodsDO> selectBatchByPrimaryKey(List<Integer> ids) {
        return this.mapper.selectBatchByPrimaryKey(ids);
    }

}
