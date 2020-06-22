package com.xandone.sharerent.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xandone.sharerent.common.BaseListResult;
import com.xandone.sharerent.mapper.RoomMapper;
import com.xandone.sharerent.pojo.RoomBean;
import com.xandone.sharerent.service.RoomService;
import com.xandone.sharerent.utils.SimpleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @Override
    public RoomBean addRoom(Map<String, Object> map) throws Exception {
        RoomBean roomBean = new RoomBean();

        roomBean.setUserId((Integer) map.get("userId"));
        roomBean.setTitle((String) map.get("title"));
        roomBean.setDiscrip((String) map.get("descrip"));
        roomBean.setPrice(880);
        roomBean.setPostTime(new Date());
        roomBean.setDestination("经开");
        roomBean.setLocation("光谷");
        roomBean.setUserPhoneNum(159);
        roomBean.setRoomBrowseCount(0);

        String imgJson= (String) map.get("images");
        String[] imgs = SimpleUtils.json2Pojo(imgJson, String[].class);
        roomBean.setCoverImg(imgs[0]);

        roomMapper.addRoom(roomBean);

        return roomBean;
    }
}
