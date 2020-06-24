package com.xandone.sharerent.service.impl;

import com.xandone.sharerent.mapper.UserMapper;
import com.xandone.sharerent.pojo.UserBean;
import com.xandone.sharerent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：xandone
 * created on  ：2020/6/24 16:34
 * description：
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserBean addUser(UserBean userBean) {
        userMapper.addUser(userBean);
        return userBean;
    }

    @Override
    public UserBean getUserById(String userOpenid) {
        return userMapper.getUserById(userOpenid);
    }
}
