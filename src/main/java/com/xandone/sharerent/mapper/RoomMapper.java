package com.xandone.sharerent.mapper;

import com.xandone.sharerent.pojo.RoomBean;
import com.xandone.sharerent.pojo.RoomCollectBean;

import java.util.List;

/**
 * @author ：xandone
 * created on  ：2020/6/17 14:34
 * description：
 */
public interface RoomMapper {
    void addRoom(RoomBean roomBean);

    List<RoomBean> getRoomList();

    void collectRoom(RoomCollectBean roomCollectBean);
}
