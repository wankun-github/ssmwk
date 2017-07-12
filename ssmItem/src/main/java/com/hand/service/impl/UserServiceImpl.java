package com.hand.service.impl;

import com.hand.dao.UserMapper;
import com.hand.model.User;
import com.hand.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;
	
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertSelective(User user) {
		// TODO Auto-generated method stub
		return userMapper.insertSelective(user);
	}

	public User selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKey(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User selectAll() {
		// TODO Auto-generated method stub
		User user=null;
		user=userMapper.selectAll();
		return user;
	}

}
