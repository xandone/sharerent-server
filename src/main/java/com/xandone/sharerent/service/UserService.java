package com.xandone.sharerent.service;

import com.xandone.sharerent.pojo.UserBean;

/**
 * @author ：xandone
 * created on  ：2020/6/24 16:34
 * description：
 */
public interface UserService {
    UserBean addUser(UserBean userBean);

    UserBean getUserById(String userOpenid);
}
