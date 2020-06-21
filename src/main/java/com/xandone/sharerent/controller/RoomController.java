package com.xandone.sharerent.controller;

import com.xandone.sharerent.common.BaseListResult;
import com.xandone.sharerent.common.ReturnCode;
import com.xandone.sharerent.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：xandone
 * created on  ：2020/6/17 16:20
 * description：
 */
@Controller
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomService roomService;

    @RequestMapping(value = "/roomlist")
    @ResponseBody
    public BaseListResult getRoomList(@RequestParam(value = "page") Integer page,
                                      @RequestParam(value = "row") Integer row) {
        BaseListResult baseResult = new BaseListResult();
        try {
            BaseListResult result = roomService.getRoomList(page, row);
            if (result != null) {
                result.setCode(ReturnCode.SUCCESS);
                result.setMsg(ReturnCode.MES_REQUEST_SUCCESS);
                return result;
            }
            baseResult.setCode(ReturnCode.ERROR_CODE);
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(ReturnCode.ERROR_CODE);
            baseResult.setMsg(ReturnCode.MES_SERVER_ERROR);
        }
        return baseResult;

    }


}
