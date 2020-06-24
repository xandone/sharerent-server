package com.xandone.sharerent.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xandone.sharerent.common.BaseListResult;
import com.xandone.sharerent.mapper.RoomMapper;
import com.xandone.sharerent.pojo.RoomBean;
import com.xandone.sharerent.pojo.RoomCollectBean;
import com.xandone.sharerent.service.RoomService;
import com.xandone.sharerent.utils.SimpleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        base.setData(list);
        base.setTotal(total);
        return base;
    }

    @Override
    public RoomBean addRoom(Map<String, Object> map) throws Exception {
        RoomBean roomBean = new RoomBean();

        roomBean.setUserOpenid((String) map.get("userId"));
        roomBean.setTitle((String) map.get("title"));
        roomBean.setDiscrip((String) map.get("descrip"));
        roomBean.setPrice(Double.parseDouble((String) map.get("price")));
        roomBean.setPostTime(new Date());
        roomBean.setDestination((String) map.get("destination"));
        roomBean.setLocation((String) map.get("location"));
        roomBean.setUserPhoneNum("1590000001");
        roomBean.setRoomBrowseCount(0);

        String imgJson = (String) map.get("images");
        String[] imgs = SimpleUtils.json2Pojo(imgJson, String[].class);
        roomBean.setCoverImg(imgs[0]);
        roomBean.setImgArr(imgJson);

        roomMapper.addRoom(roomBean);

        return roomBean;
    }

    @Override
    public void collectRoom(int roomId, String userOpenid) throws Exception {
        RoomCollectBean roomCollectBean = new RoomCollectBean(roomId, userOpenid, new Date());
        roomMapper.collectRoom(roomCollectBean);
    }

    @Override
    public BaseListResult getMyRoomList(Integer page, Integer row, String userOpenid) {
        BaseListResult base = new BaseListResult();
        PageHelper.startPage(page, row);
        List<RoomBean> list;
        list = roomMapper.getMyRoomList(userOpenid);
        int total = (int) new PageInfo<>(list).getTotal();
        base.setData(list);
        base.setTotal(total);
        return base;
    }

    @Override
    public BaseListResult getMyCollectList(Integer page, Integer row, String userOpenid) {
        BaseListResult base = new BaseListResult();
        PageHelper.startPage(page, row);
        List<RoomCollectBean> list;
        List<RoomBean> list2 = new ArrayList<>();
        list = roomMapper.getMyCollectList(userOpenid);
        int total = (int) new PageInfo<>(list).getTotal();
        for (int i = 0; i < list.size(); i++) {
            RoomBean temp = roomMapper.getRoomById(list.get(i).getRoomId());
            if (temp != null) {
                list2.add(temp);
            }
        }
        base.setData(list2);
        base.setTotal(total);
        return base;
    }
}
