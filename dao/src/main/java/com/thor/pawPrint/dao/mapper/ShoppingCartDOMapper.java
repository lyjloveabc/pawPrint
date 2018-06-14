package com.thor.pawPrint.dao.mapper;

import com.thor.pawPrint.bean.entity.ShoppingCartDO;
import com.thor.pawPrint.core.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShoppingCartDOMapper extends BaseMapper<ShoppingCartDO> {
    /**
     * 根据购物车记录number获取总价
     *
     * @param numbers 购物车记录number
     * @return 总价
     */
    double selectTotalMoneyByShoppingCartNumber(@Param("numbers") String[] numbers);

    /**
     * 根据用户ID获取该用户的数据
     *
     * @param userId 用户ID
     * @return 改用户的数据
     */
    List<ShoppingCartDO> selectByUserId(@Param("userId") Integer userId);

    /**
     * 批量更新购物车记录的状态：未下单 -> 已下单
     *
     * @param numbers 购物车记录number
     * @param status  状态
     * @return 影响行数
     */
    int updateBatchStatusByNumber(@Param("numbers") String[] numbers, @Param("status") String status);

}