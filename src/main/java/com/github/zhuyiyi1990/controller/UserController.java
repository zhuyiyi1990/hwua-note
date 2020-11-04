package com.github.zhuyiyi1990.controller;

import com.github.zhuyiyi1990.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testReturnString")
    public String testReturnString(Model model) {
        User user = new User();
        user.setUsername("小明");
        user.setPassword("123456");
        user.setAge(18);
        model.addAttribute("user", user);
        return "success";
    }

    @RequestMapping("testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行testVoid");
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
        System.out.println(request.getContextPath());
//        response.sendRedirect(request.getContextPath() + "/index.jsp");
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write("json字符串");
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView mv = new ModelAndView();
        User user = new User();
        user.setUsername("小强");
        user.setPassword("111111");
        user.setAge(18);
        mv.addObject("user", user);
        mv.setViewName("success");
        return mv;
    }

    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect() {
        System.out.println("执行testForwardOrRedirect");
//        return "forward:/WEB-INF/pages/success.jsp";
        return "redirect:/user/testModelAndView";
    }

    @RequestMapping("/testResponseBody")
    public @ResponseBody
    User testResponseBody(@RequestBody User user) {
        System.out.println("执行testResponseBody");
        System.out.println(user);
        user.setAge(16);
        return user;
    }
}
