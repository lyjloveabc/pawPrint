package com.thor.pawPrint.web.controller.userCenter;

import com.thor.pawPrint.bean.dto.UserDTO;
import com.thor.pawPrint.biz.controller.userCenter.UserCenterBiz;
import com.thor.pawPrint.core.common.result.Result;
import com.thor.pawPrint.core.common.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户中心
 * Created by Thor on 2017/2/13.
 * happy coding - 1203!
 */
@Controller
@RequestMapping("userCenter")
@Slf4j
public class UserCenterController {
    @Autowired
    private UserCenterBiz userCenterBiz;

    /**
     * 用户中心
     *
     * @return ModelAndView
     */
    @RequestMapping("userCenterPage")
    public ModelAndView userCenterPage() {
        ModelAndView modelAndView = new ModelAndView("weChat/userCenter/userCenter");

        Result<UserDTO> currentUserResult =  userCenterBiz.currentUser();
        if(ResultCode.isSuccess(currentUserResult.getCode())){
            modelAndView.addObject("user", currentUserResult.getData());
        }

        return modelAndView;
    }

}
