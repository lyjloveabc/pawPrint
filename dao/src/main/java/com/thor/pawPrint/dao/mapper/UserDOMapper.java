package com.thor.pawPrint.dao.mapper;

import com.thor.pawPrint.bean.entity.UserDO;
import com.thor.pawPrint.core.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDOMapper extends BaseMapper<UserDO> {
    /**
     * 根据openId获取用户
     *
     * @param openId openId
     * @return 用户
     */
    UserDO selectByOpenId(@Param("openId") String openId);

    /**
     * 根据openId更新用户
     *
     * @param userPO 入参
     * @return 影响行数
     */
    Integer updateByOpenIdSelective(UserDO userPO);

}