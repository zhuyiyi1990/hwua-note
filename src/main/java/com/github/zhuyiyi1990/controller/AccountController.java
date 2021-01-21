package com.github.zhuyiyi1990.controller;

import com.github.zhuyiyi1990.pojo.Account;
import com.github.zhuyiyi1990.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller("accountController")
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(ModelMap modelMap) {
        System.out.println("表现层:查询所有账户...");
        List<Account> accounts = accountService.findAll();
        modelMap.addAttribute("accounts", accounts);
        return "list";
    }

    @RequestMapping("/saveAccount")
    public String saveAccount(Account account) {
        accountService.saveAccount(account);
        return "redirect:/account/findAll";
    }
}
