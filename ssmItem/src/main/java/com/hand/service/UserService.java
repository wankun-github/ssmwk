package com.hand.service;

import com.hand.model.User;

public interface UserService {
		int deleteByPrimaryKey(Integer id);

	    int insert(User user);

	    int insertSelective(User user);

		User selectByPrimaryKey(Integer id);

		User selectAll();
	    
	    int updateByPrimaryKeySelective(User user);

	    int updateByPrimaryKey(User user);
}
