package com.github.zhuyiyi1990.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("accountController")
@RequestMapping("/account")
public class AccountController {
    @RequestMapping("/findAccount")
    public String findAccount() {
        System.out.println("查询了账户");
        return "success";
    }

    @RequestMapping(value = "/saveAccount", method = RequestMethod.POST)
    public String saveAccount() {
        System.out.println("保存了账户");
        return "success";
    }

    @RequestMapping(value = "/deleteAccount", params = {"name"})
    public String deleteAccount() {
        System.out.println("删除了账户");
        return "success";
    }
}
