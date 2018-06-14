package com.thor.pawPrint.dao.mapper;

import com.thor.pawPrint.bean.entity.WeChatConfigDO;
import com.thor.pawPrint.core.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WeChatConfigDOMapper extends BaseMapper<WeChatConfigDO> {
    /**
     * 获取当前使用的微信配置
     *
     * @return 返回当前正在使用的微信配置
     */
    WeChatConfigDO selectIsUsing();

}