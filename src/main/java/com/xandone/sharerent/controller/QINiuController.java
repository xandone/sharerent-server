package com.xandone.sharerent.controller;

import com.xandone.sharerent.common.BaseResult;
import com.xandone.sharerent.utils.UploadQiNiu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/qiniu")
public class QINiuController {

    @RequestMapping(value = "/getToken")
    @ResponseBody
    public BaseResult addJoke() {
        BaseResult baseResult = new BaseResult();
        try {
            String token = UploadQiNiu.getUpToken();
            baseResult.setMsg(token);
        } catch (Exception e) {

        }

        return baseResult;
    }
}
