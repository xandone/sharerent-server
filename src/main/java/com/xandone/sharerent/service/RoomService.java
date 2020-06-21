package com.xandone.sharerent.service;

import com.xandone.sharerent.common.BaseListResult;


public interface RoomService {
    BaseListResult getRoomList(Integer page, Integer row);
}
