package com.github.zhuyiyi1990.hwuanote.dao.impl;

import com.github.zhuyiyi1990.hwuanote.dao.IAccountDao;
import com.github.zhuyiyi1990.hwuanote.pojo.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class AccountDaoImpl2 extends JdbcDaoSupport implements IAccountDao {

    @Override
    public Account findAccountById(int id) {
        List<Account> accounts = getJdbcTemplate().query("select * from account2 where id = ?", new BeanPropertyRowMapper<Account>(Account.class), id);
        return accounts.isEmpty() ? null : accounts.get(0);
    }

    @Override
    public Account findAccountByName(String name) {
        List<Account> accounts = getJdbcTemplate().query("select * from account2 where name = ?", new BeanPropertyRowMapper<Account>(Account.class), name);
        if (accounts.isEmpty()) {
            return null;
        }
        if (accounts.size() > 1) {
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    @Override
    public int update(Account account) {
        return getJdbcTemplate().update("update account2 set name = ?, money = ? where id = ?", account.getName(), account.getMoney(), account.getId());
    }

}
