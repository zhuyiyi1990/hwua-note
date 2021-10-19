package com.github.zhuyiyi1990.hwuanote.dao;

import com.github.zhuyiyi1990.hwuanote.pojo.Role;

import java.util.List;

public interface IRoleDao {

    /**
     * 查询所有的角色,及对应的所有用户信息
     *
     * @return
     */
    List<Role> findAll();

}
