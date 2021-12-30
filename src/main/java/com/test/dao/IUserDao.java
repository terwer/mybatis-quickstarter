package com.test.dao;

import com.test.pojo.User;

import java.util.List;

public interface IUserDao {
    public List<User> findAll() throws  Exception;

    public void saveUser(User user) throws Exception;

    public void updateUser(User user) throws Exception;

    public void deleteUser(Integer id) throws Exception;

    public List<User> findByCondition(User user) throws Exception;
}
