package com.xandone.sharerent.common;

import java.util.List;

/**
 * @author ：xandone
 * created on  ：2019/11/22 15:04
 * description：
 */
public class BaseResult {
    private int code;
    private String msg;
    private List<?> data;

    public BaseResult() {
    }

    public BaseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResult(int code, String msg, List<?> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
