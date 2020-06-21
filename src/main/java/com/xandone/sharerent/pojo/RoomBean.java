package com.xandone.sharerent.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author ：xandone
 * created on  ：2020/6/17 14:34
 * description：
 */
public class RoomBean {
    private int roomId;
    private int userId;
    private String title;
    private String discrip;
    private double price;
    private int userPhoneNum;
    private int roomBrowseCount;
    private String location;
    private String destination;
    private String coverImg;
    private Date postTime;

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscrip() {
        return discrip;
    }

    public void setDiscrip(String discrip) {
        this.discrip = discrip;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUserPhoneNum() {
        return userPhoneNum;
    }

    public void setUserPhoneNum(int userPhoneNum) {
        this.userPhoneNum = userPhoneNum;
    }

    public int getRoomBrowseCount() {
        return roomBrowseCount;
    }

    public void setRoomBrowseCount(int roomBrowseCount) {
        this.roomBrowseCount = roomBrowseCount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }
}
