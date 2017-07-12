package com.hand.service.impl;

import com.hand.dao.UserMapper;
import com.hand.model.User;
import com.hand.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wankun on 2017/7/6.
 */
@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    public int saveUser(User user){
        return userMapper.saveUser(user);
    }
    public int updateUser(User user){
        return userMapper.updateUser(user);
    }
    public int removeUser(Integer id){
        return userMapper.removeUser(id);
    }
    public List<User> queryAllUser(){
        return userMapper.queryAllUser();
    }

    @Override
    public List<User> queryUserByKey(String searchKey) {
        return userMapper.queryUserByKey(searchKey);
    }

    public User queryUserById(Integer id) {
        return userMapper.queryUserById(id);
    }
    public User getUserByNameAndPwd(String userName, String userPassword) {
        return userMapper.getUserByNameAndPwd(userName,userPassword);
    }
}
