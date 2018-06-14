package com.thor.pawPrint.dao.daoTemp;

import com.thor.pawPrint.bean.entity.UserDO;
import com.thor.pawPrint.core.base.BaseDAO;
import com.thor.pawPrint.dao.mapper.UserDOMapper;
import org.springframework.stereotype.Component;

/**
 * Created by Thor on 2017/2/10.
 * happy coding - 1203!
 */
@Component
public class UserDAO extends BaseDAO<UserDO, UserDOMapper> {
    /**
     * 根据openId获取用户
     *
     * @param openId openId
     * @return 用户
     */
    public UserDO selectByOpenId(String openId) {
        return this.mapper.selectByOpenId(openId);
    }

    /**
     * 根据openId更新用户
     *
     * @param userPO 入参
     * @return 影响行数
     */
    public Integer updateByOpenIdSelective(UserDO userPO) {
        return this.mapper.updateByOpenIdSelective(userPO);
    }

}
