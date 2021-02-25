package com.github.zhuyiyi1990.dao;

import com.github.zhuyiyi1990.pojo.QueryVo;
import com.github.zhuyiyi1990.pojo.User;

import java.util.List;

public interface IUserDao {

    /**
     * 查找所有的用户
     *
     * @return
     */
    public abstract List<User> findAll();

    /**
     * 通过id查找用户
     *
     * @param id
     * @return
     */
    public abstract User findById(Integer id);

    /**
     * 保存用户
     *
     * @param user
     * @return 影响的行数
     */
    public abstract int saveUser(User user);

    /**
     * 更新用户
     *
     * @param user
     * @return 影响的行数
     */
    public abstract int updateUser(User user);

    /**
     * 删除用户
     *
     * @param id
     * @return 影响的行数
     */
    public abstract int deleteUser(int id);

    /**
     * 通过名称模糊查找用户
     *
     * @param username
     * @return
     */
    public abstract List<User> findByName(String username);

    /**
     * 统计总记录条数
     *
     * @return
     */
    public abstract int findTotal();

    public abstract List<User> findByQueryVo(QueryVo vo);

}
