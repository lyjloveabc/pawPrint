package com.thor.pawPrint.biz.controller.userCenter;

import com.thor.pawPrint.bean.dto.UserDTO;
import com.thor.pawPrint.bean.entity.UserDO;
import com.thor.pawPrint.core.common.constant.Constant;
import com.thor.pawPrint.core.common.result.Result;
import com.thor.pawPrint.core.common.result.ResultCode;
import com.thor.pawPrint.core.utils.object.ObjectCopyUtil;
import com.thor.pawPrint.core.utils.system.ResultUtil;
import com.thor.pawPrint.dao.daoTemp.UserDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Thor on 2017/3/1.
 * happy coding - 1203!
 */
@Service
@Slf4j
public class UserCenterBizImpl implements UserCenterBiz {
    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private UserDAO userDAO;


    @Override
    public Result<UserDTO> currentUser() {
        HttpSession httpSession = httpServletRequest.getSession();
        Integer userId = Integer.parseInt((String) httpSession.getAttribute(Constant.USER_ID));

        if (ObjectUtils.isEmpty(userId)) {
            return ResultUtil.errorResult(ResultCode.NO_LOGIN);
        } else {
            UserDO userDO = userDAO.selectByPrimaryKey(userId);
            if (ObjectUtils.isEmpty(userId)) {
                return ResultUtil.errorResult(ResultCode.NO_LOGIN);
            } else {
                return ResultUtil.successResult(ObjectCopyUtil.copyObject(userDO, UserDTO.class));
            }
        }
    }

}
