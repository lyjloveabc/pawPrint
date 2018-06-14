package com.thor.pawPrint.biz.controller.userCenter;

import com.thor.pawPrint.bean.dto.UserDTO;
import com.thor.pawPrint.core.common.result.Result;

/**
 * Created by Thor on 2017/3/1.
 * happy coding - 1203!
 */
public interface UserCenterBiz {
    Result<UserDTO> currentUser();

}
