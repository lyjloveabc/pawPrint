package com.thor.pawPrint.dao.daoTemp;

import com.thor.pawPrint.bean.entity.WeChatConfigDO;
import com.thor.pawPrint.core.base.BaseDAO;
import com.thor.pawPrint.dao.mapper.WeChatConfigDOMapper;
import org.springframework.stereotype.Component;

/**
 * Created by Thor on 2017/2/7.
 * happy coding - 1203!
 */
@Component
public class WeChatConfigDAO extends BaseDAO<WeChatConfigDO, WeChatConfigDOMapper> {
    /**
     * 获取当前使用的微信配置
     *
     * @return 返回当前正在使用的微信配置
     */
    public WeChatConfigDO selectIsUsing() {
        return this.mapper.selectIsUsing();
    }

}
