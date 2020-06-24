package com.xandone.sharerent.controller;

import com.xandone.sharerent.common.BaseResult;
import com.xandone.sharerent.common.ReturnCode;
import com.xandone.sharerent.pojo.UserBean;
import com.xandone.sharerent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/userInfo")
    @ResponseBody
    public BaseResult getUserById(@RequestParam(value = "openId") String openId) {
        BaseResult baseResult = new BaseResult();
        UserBean userBean;
        try {
            userBean = userService.getUserById(openId);
            List<UserBean> list = new ArrayList<>();
            list.add(userBean);
            baseResult.setData(list);
            baseResult.setCode(ReturnCode.SUCCESS);
        } catch (
                Exception e) {
            e.printStackTrace();
            baseResult.setCode(ReturnCode.ERROR_CODE);
            return baseResult;
        }

        return baseResult;
    }

}
