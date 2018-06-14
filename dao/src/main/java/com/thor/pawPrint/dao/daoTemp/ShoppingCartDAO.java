package com.thor.pawPrint.dao.daoTemp;

import com.thor.pawPrint.bean.entity.ShoppingCartDO;
import com.thor.pawPrint.core.base.BaseDAO;
import com.thor.pawPrint.dao.mapper.ShoppingCartDOMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Thor on 2017/2/14.
 * happy coding - 1203!
 */
@Component
public class ShoppingCartDAO extends BaseDAO<ShoppingCartDO, ShoppingCartDOMapper> {
    /**
     * 根据购物车记录number获取总价
     *
     * @param numbers 购物车记录number
     * @return 总价
     */
    public double selectTotalMoneyByShoppingCartNumber(String[] numbers) {
        return this.mapper.selectTotalMoneyByShoppingCartNumber(numbers);
    }

    /**
     * 根据用户ID获取该用户的数据
     *
     * @param userId 用户ID
     * @return 改用户的数据
     */
    public List<ShoppingCartDO> selectByUserId(Integer userId) {
        return this.mapper.selectByUserId(userId);
    }

    /**
     * 批量更新购物车记录的状态：未下单 -> 已下单
     *
     * @param numbers 购物车记录number
     * @param status  状态
     * @return 影响行数
     */
    public int updateBatchStatusByNumber(String[] numbers, String status) {
        return this.mapper.updateBatchStatusByNumber(numbers, status);
    }

}
