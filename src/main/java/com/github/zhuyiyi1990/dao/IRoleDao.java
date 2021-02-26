package com.github.zhuyiyi1990.dao;

import com.github.zhuyiyi1990.pojo.Role;

import java.util.List;

public interface IRoleDao {

    /**
     * 查询所有的角色,及对应的所有用户信息
     *
     * @return
     */
    public abstract List<Role> findAll();

}
