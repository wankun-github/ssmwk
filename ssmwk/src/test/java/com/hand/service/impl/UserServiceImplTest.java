package com.hand.service.impl;

import com.hand.model.User;
import com.hand.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wankun on 2017/7/6.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring-mybatis.xml"})
public class UserServiceImplTest {

    @Autowired
    private UserService userService;
    @Test
    public void saveUser() throws Exception {
        User user = new User();
        user.setUserName("zhangsan");
        user.setUserPassword("123");
        user.setUserAge(12);
        userService.saveUser(user);
    }

    @Test
    public void updateUser() throws Exception {
        User user = new User();
        user.setUserId(1);
        user.setUserName("lisi");
        user.setUserPassword("1234");
        user.setUserAge(30);
        userService.updateUser(user);
    }

    @Test
    public void removeUser() throws Exception {
        userService.removeUser(1);
    }

    @Test
    public void queryAllUser() throws Exception {
        List<User> userList = userService.queryAllUser();
        for(User u : userList){
            System.out.println(u.toString());
        }
    }

}