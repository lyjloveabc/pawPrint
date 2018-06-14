package com.thor.pawPrint.biz.controller.user;

import com.thor.pawPrint.bean.dto.UserDTO;
import com.thor.pawPrint.bean.dto.simple.TrueOrFalse;
import com.thor.pawPrint.bean.param.UserPO;
import com.thor.pawPrint.core.common.result.Result;

/**
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */
public interface UserBiz {
    /**
     * 添加一个用户
     *
     * @param userPO 用户参数
     * @return 添加是否成功
     */
    Result<TrueOrFalse> add(UserPO userPO);

    /**
     * 根据ID删除用户
     *
     * @param id 用户ID
     * @return 删除是否成功
     */
    Result<TrueOrFalse> delete(Integer id);

    /**
     * 修改用户
     *
     * @param userPO 用户参数
     * @return 修改是否成功
     */
    Result<TrueOrFalse> modify(UserPO userPO);

    /**
     * 根据ID获取用户数据
     *
     * @param id 用户ID
     * @return 用户
     */
    Result<UserDTO> get(Integer id);

}
