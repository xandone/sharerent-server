package com.xandone.sharerent.controller;

import com.xandone.sharerent.common.BaseResult;
import com.xandone.sharerent.common.Config;
import com.xandone.sharerent.common.ReturnCode;
import com.xandone.sharerent.pojo.UserBean;
import com.xandone.sharerent.pojo.WxUserBean;
import com.xandone.sharerent.service.UserService;
import com.xandone.sharerent.utils.HttpRequestUtil;
import com.xandone.sharerent.utils.SimpleUtils;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
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
            if (userBean != null) {
                list.add(userBean);
            }
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

    @RequestMapping(value = "/jscode/userInfo")
    @ResponseBody
    public BaseResult getUserByJsCode(@RequestParam(value = "jsCode") String jsCode,
                                      @RequestParam(value = "nickname") String nickname,
                                      @RequestParam(value = "userIcon") String userIcon) {
        BaseResult baseResult = new BaseResult();
        UserBean userBean;
        List<UserBean> list = new ArrayList<>();
        try {
            String params = "appid=" + Config.WX_APPID + "&" +
                    "secret=" + Config.WX_APPSECRET + "&" +
                    "grant_type=" + Config.WX_GRANT_TYPE + "&" +
                    "js_code=" + jsCode;
            String json = HttpRequestUtil.sendGet(Config.WX_OPENID_URL, params);
            WxUserBean wxUserBean = SimpleUtils.json2Pojo(json, WxUserBean.class);
            if (wxUserBean == null || TextUtils.isEmpty(wxUserBean.getOpenid())) {
                baseResult.setData(list);
                return baseResult;
            }
            userBean = userService.getUserById(wxUserBean.getOpenid());

            if (userBean != null) {
                //数据库有记录
                list.add(userBean);
            } else {
                // 第一次登陆
                UserBean temp = new UserBean();
                temp.setNickname(nickname);
                temp.setRegisterTime(new Date());
                temp.setLastLoginTime(new Date());
                temp.setUserOpenid(wxUserBean.getOpenid());
                temp.setUserIcon(userIcon);
                userService.addUser(temp);
            }
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
