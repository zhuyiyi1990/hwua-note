package com.github.zhuyiyi1990.dao;

import com.github.zhuyiyi1990.pojo.User;

import java.util.List;

public interface IUserDao {

    /**
     * 查找所有的用户
     *
     * @return
     */
    public abstract List<User> findAll(String orderByColumn);

}
