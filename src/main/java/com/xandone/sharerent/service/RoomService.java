package com.xandone.sharerent.service;

import com.xandone.sharerent.common.BaseListResult;
import com.xandone.sharerent.pojo.RoomBean;

import java.util.Map;


public interface RoomService {
    BaseListResult getRoomList(Integer page, Integer row);

    RoomBean addRoom(Map<String, Object> map) throws Exception;
}
