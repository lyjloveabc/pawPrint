package com.thor.pawPrint.web.controller.user;

import com.thor.pawPrint.bean.dto.UserDTO;
import com.thor.pawPrint.bean.dto.simple.TrueOrFalse;
import com.thor.pawPrint.bean.param.UserPO;
import com.thor.pawPrint.biz.controller.user.UserBiz;
import com.thor.pawPrint.core.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户控制器
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */
@Controller
@RequestMapping("user")
@Slf4j
public class UserController {
    @Autowired
    private UserBiz userBiz;

    /**
     * 添加一个用户
     *
     * @param userPO 用户参数
     * @return 添加是否成功
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Result<TrueOrFalse> add(UserPO userPO) {
        return userBiz.add(userPO);
    }

    /**
     * 根据ID删除用户
     *
     * @param id 用户ID
     * @return 删除是否成功
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public Result<TrueOrFalse> delete(Integer id) {
        return userBiz.delete(id);
    }

    /**
     * 修改用户
     *
     * @param userPO 用户参数
     * @return 修改是否成功
     */
    @RequestMapping(value = "modify", method = RequestMethod.PUT)
    public Result<TrueOrFalse> modify(UserPO userPO) {
        return userBiz.modify(userPO);
    }

    /**
     * 根据ID获取用户数据
     *
     * @param id 用户ID
     * @return 用户
     */
    @RequestMapping(value = "get", method = RequestMethod.GET)
    public Result<UserDTO> get(Integer id) {
        return userBiz.get(id);
    }

}
