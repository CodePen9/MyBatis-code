package com.jiang.dao;

import com.jiang.pojo.User;

import java.util.List;

/**
 * @Title:
 * @author: JiangPeng
 */
public interface UserDao {
    //获取所有用户
    public List<User> getUserList();

    //根据id查找用户
    public User getUserById(Integer id);


}
