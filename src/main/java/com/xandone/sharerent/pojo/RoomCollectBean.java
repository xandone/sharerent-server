package com.xandone.sharerent.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author ：xandone
 * created on  ：2020/6/24 16:23
 * description：
 */
public class RoomCollectBean {
    private int roomId;
    private String userOpenid;
    private Date collectTime;

    public RoomCollectBean() {
    }

    public RoomCollectBean(int roomId, String userOpenid, Date collectTime) {
        this.roomId = roomId;
        this.userOpenid = userOpenid;
        this.collectTime = collectTime;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getUserOpenid() {
        return userOpenid;
    }

    public void setUserOpenid(String userOpenid) {
        this.userOpenid = userOpenid;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }
}
