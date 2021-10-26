package com.github.zhuyiyi1990.hwuanote.service;

public interface IAccountService {

    //以下三个方法为了选择三类：无参无返回值，有参无返回值，无参有返回值，有参有返回值相当于前两个方法组合

    /**
     * 模拟保存账户
     */
    void saveAccount();

    /**
     * 模拟更新账户
     *
     * @param i
     */
    void updateAccount(int i);

    /**
     * 删除账户
     *
     * @return
     */
    int deleteAccount();

}
