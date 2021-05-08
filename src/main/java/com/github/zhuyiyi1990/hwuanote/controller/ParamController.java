package com.github.zhuyiyi1990.hwuanote.controller;

import com.github.zhuyiyi1990.hwuanote.pojo.Account;
import com.github.zhuyiyi1990.hwuanote.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/param")
public class ParamController {

    @RequestMapping("/testParam")
    public String testParam(String username, String password) {
        System.out.println("参数测试");
        System.out.println("用户名:" + username);
        System.out.println("密码:" + password);
        return "success";
    }

    /**
     * 请求参数绑定把数据封装到JavaBean的类对象中
     *
     * @param account
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account) {
        System.out.println("保存账户:" + account);
        return "success";
    }

    @RequestMapping("/saveUser")
    public String saveUser(User user) {
        System.out.println("保存用户:" + user);
        return "success";
    }

    /**
     * 原生的API
     *
     * @return
     */
    @RequestMapping("testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request);
        HttpSession session = request.getSession();
        System.out.println(session);
        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);
        System.out.println(response);
        return "success";
    }

}
