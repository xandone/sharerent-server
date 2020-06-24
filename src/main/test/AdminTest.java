import com.xandone.sharerent.mapper.*;
import com.xandone.sharerent.pojo.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class AdminTest {
    @Test
    public void addRoom() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        RoomMapper mapper = context.getBean(RoomMapper.class);

        RoomBean roomBean = new RoomBean();
        roomBean.setUserId(250);
        roomBean.setTitle("FIFA探讨世界杯扩军：中国可能要进世界杯？");
        roomBean.setDiscrip("2018年4月，南美足协主席多明格斯公开发言，希望国际足联考虑在2022年实现世界杯扩军，因凡蒂诺顺水推舟，"
                + "开始寻求卡塔尔的合作。但卡塔尔不愿意与周边国家共同举办世界杯，而它自身的场馆数量，又无法满足48支球队比赛的需求，这一计划才最终作罢。");
        roomBean.setPostTime(new Date());
        mapper.addRoom(roomBean);

    }

    @Test
    public void getRoomList() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        RoomMapper mapper = context.getBean(RoomMapper.class);
        List<RoomBean> list = mapper.getRoomList();
        System.out.println(list.get(0).getTitle());
    }

    @Test
    public void addUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        UserMapper mapper = context.getBean(UserMapper.class);
//        UserBean userBean = new UserBean();
//        userBean.setUserOpenid("1222");
//        userBean.setBanned(0);
//        userBean.setNickname("狗蛋");
//        userBean.setWxNum("11111123336");
//        userBean.setPhoneNum("1599999999");
//        userBean.setLastLoginTime(new Date());
//        userBean.setRegisterTime(new Date());
//        mapper.addUser(userBean);

        UserBean userBean = mapper.getUserById("1222");
        userBean.setPubCount(1);
        mapper.updateUser(userBean);

    }

    @Test
    public void collectRoom() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        RoomMapper mapper = context.getBean(RoomMapper.class);
        RoomCollectBean collectBean = new RoomCollectBean(1, "251", new Date());
        mapper.collectRoom(collectBean);
    }
}