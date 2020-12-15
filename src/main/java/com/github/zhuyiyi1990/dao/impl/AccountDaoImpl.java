package com.github.zhuyiyi1990.dao.impl;

import com.github.zhuyiyi1990.dao.IAccountDao;
import com.github.zhuyiyi1990.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoImpl implements IAccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account findAccountById(int id) {
        List<Account> list = jdbcTemplate.query("select * from account2 where id = ?", new BeanPropertyRowMapper<Account>(Account.class), id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public Account findAccountByName(String name) {
        List<Account> list = jdbcTemplate.query("select * from account2 where name = ?", new BeanPropertyRowMapper<Account>(Account.class), name);
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() > 1) {
            throw new RuntimeException("结果集不唯一");
        }
        return list.get(0);
    }

    @Override
    public int update(Account account) {
        return jdbcTemplate.update("update account2 set name=?, money=? where id=?", account.getName(), account.getMoney(), account.getId());
    }
}
