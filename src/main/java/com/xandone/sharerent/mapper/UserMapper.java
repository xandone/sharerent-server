package com.xandone.sharerent.mapper;

import com.xandone.sharerent.pojo.UserBean;

/**
 * @author ：xandone
 * created on  ：2020/6/18 9:41
 * description：
 */
public interface UserMapper {
    void addUser(UserBean userBean);

    UserBean getUserById(String userOpenid);

    void updateUser(UserBean userBean);
}
