package com.hand.service.impl;

import com.hand.model.User;
import com.hand.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * Created by wankun on 2017/7/6.
 */
public class UserServiceImplTest {
    @Autowired
    UserService userService;
    @Test
    public void deleteByPrimaryKey() throws Exception {
    }

    @Test
    public void insert() throws Exception {
    }

    @Test
    public void insertSelective() throws Exception {
        User user = new User();
        user.setId(1);
        user.setAge(10);
        user.setName("zhangsan");
        //Assert.assertTrue(userService.insertSelective(user));
        //userId = user.getUserId();
        userService.insertSelective(user);
        //Assert.
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }

    @Test
    public void selectAll() throws Exception {
    }

}