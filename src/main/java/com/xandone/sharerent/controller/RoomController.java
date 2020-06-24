package com.xandone.sharerent.controller;

import com.xandone.sharerent.common.BaseListResult;
import com.xandone.sharerent.common.BaseResult;
import com.xandone.sharerent.common.ReturnCode;
import com.xandone.sharerent.pojo.RoomBean;
import com.xandone.sharerent.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult addArt(@RequestBody Map<String, Object> map) {
        BaseResult baseResult = new BaseResult();
        RoomBean roomBean;
        try {
            roomBean = roomService.addRoom(map);
            List<RoomBean> list = new ArrayList<>();
            list.add(roomBean);
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

    @RequestMapping(value = "/myRoomlist")
    @ResponseBody
    public BaseListResult getMyRoomList(@RequestParam(value = "page") Integer page,
                                        @RequestParam(value = "row") Integer row,
                                        @RequestParam(value = "openId") String openId) {
        BaseListResult baseResult = new BaseListResult();
        try {
            BaseListResult result = roomService.getMyRoomList(page, row, openId);
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

    @RequestMapping(value = "/myCollectlist")
    @ResponseBody
    public BaseListResult getMyCollectList(@RequestParam(value = "page") Integer page,
                                           @RequestParam(value = "row") Integer row,
                                           @RequestParam(value = "openId") String openId) {
        BaseListResult baseResult = new BaseListResult();
        try {
            BaseListResult result = roomService.getMyCollectList(page, row, openId);
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
