package com.thor.pawPrint.biz.controller.user;

import com.thor.pawPrint.bean.dto.UserDTO;
import com.thor.pawPrint.bean.dto.simple.TrueOrFalse;
import com.thor.pawPrint.bean.entity.UserDO;
import com.thor.pawPrint.bean.param.UserPO;
import com.thor.pawPrint.core.common.result.Result;
import com.thor.pawPrint.core.common.result.ResultCode;
import com.thor.pawPrint.core.utils.object.ObjectCopyUtil;
import com.thor.pawPrint.core.utils.system.ResultUtil;
import com.thor.pawPrint.dao.daoTemp.UserDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

/**
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */
@Service
@Slf4j
public class UserBizImpl implements UserBiz {
    @Autowired
    private UserDAO userDAO;

    @Override
    public Result<TrueOrFalse> add(UserPO userPO) {
        if (ObjectUtils.isEmpty(userPO)) {
            return ResultUtil.errorResult(ResultCode.PARAM_ERROR);
        }

        Integer id = userPO.getId();
        if (!ObjectUtils.isEmpty(id)) {
            return ResultUtil.errorResult(ResultCode.PARAM_ID_ERROR);
        }

        String openId = userPO.getOpenid();
        if (ObjectUtils.isEmpty(openId)) {
            return ResultUtil.errorResult(ResultCode.NO_OPEN_ID);
        }

        UserDO userDO = ObjectCopyUtil.copyObject(userPO, UserDO.class);

        userDAO.insertSelective(userDO);

        return ResultUtil.successResult(TrueOrFalse.getTrue());
    }

    @Transactional
    @Override
    public Result<TrueOrFalse> delete(Integer id) {
        if (ObjectUtils.isEmpty(id)) {
            return ResultUtil.errorResult(ResultCode.PARAM_ERROR);
        }

        userDAO.deleteByPrimaryKey(id);
        /// TODO: 2017/2/10 级联删除其他数据

        return ResultUtil.successResult(TrueOrFalse.getTrue());
    }

    @Override
    public Result<TrueOrFalse> modify(UserPO userPO) {
        if (ObjectUtils.isEmpty(userPO)) {
            return ResultUtil.errorResult(ResultCode.PARAM_ERROR);
        }

        Integer id = userPO.getId();
        if (ObjectUtils.isEmpty(id)) {
            return ResultUtil.errorResult(ResultCode.PARAM_NO_ID);
        }

        userDAO.updateByPrimaryKeySelective(ObjectCopyUtil.copyObject(userPO, UserDO.class));

        return ResultUtil.successResult(TrueOrFalse.getTrue());
    }

    @Override
    public Result<UserDTO> get(Integer id) {
        if (ObjectUtils.isEmpty(id)) {
            return ResultUtil.errorResult(ResultCode.PARAM_ERROR);
        }

        UserDO userDO = userDAO.selectByPrimaryKey(id);

        return ResultUtil.successResult(ObjectCopyUtil.copyObject(userDO, UserDTO.class));
    }

}
