package com.hand.dao;

import com.hand.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wankun on 2017/7/6.
 */
public interface UserMapper {
    /**
     * 保存用户
     * @param user
     * @return
     */
    int saveUser(User user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    int removeUser(Integer id);

    /**
     * 查询所有用户
     * @return
     */
    List<User> queryAllUser();

    /**
     * 模糊查询用户列表
     * @param searchKey
     * @return
     */
    List<User> queryUserByKey(String searchKey);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User queryUserById(Integer id);

    /**
     * 根据账号密码查询用户
     * @param userName
     * @param userPassword
     * @return
     */
    User getUserByNameAndPwd(@Param("userName") String userName,@Param("userPassword") String userPassword);
}
