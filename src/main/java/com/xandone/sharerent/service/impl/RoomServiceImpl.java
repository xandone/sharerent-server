package com.xandone.sharerent.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xandone.sharerent.common.BaseListResult;
import com.xandone.sharerent.mapper.RoomMapper;
import com.xandone.sharerent.pojo.RoomBean;
import com.xandone.sharerent.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：xandone
 * created on  ：2020/6/18 11:39
 * description：
 */
@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomMapper roomMapper;

    @Override
    public BaseListResult getRoomList(Integer page, Integer row) {
        BaseListResult base = new BaseListResult();
        PageHelper.startPage(page, row);
        List<RoomBean> list;
        list = roomMapper.getRoomList();
        int total = (int) new PageInfo<>(list).getTotal();

        for (RoomBean bean : list) {
//            dealComment(bean);
        }

        base.setData(list);
        base.setTotal(total);
        return base;
    }
}
