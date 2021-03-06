package com.xandone.sharerent.service;

import com.xandone.sharerent.common.BaseListResult;
import com.xandone.sharerent.pojo.RoomBean;

import java.util.Map;


public interface RoomService {
    BaseListResult getRoomList(Integer page, Integer row);

    RoomBean addRoom(Map<String, Object> map) throws Exception;

    void collectRoom(int roomId, String userOpenid) throws Exception;

    BaseListResult getMyRoomList(Integer page, Integer row, String userOpenid);

    BaseListResult getMyCollectList(Integer page, Integer row, String userOpenid);
}
