package com.github.zhuyiyi1990.hwuanote.controller;

import com.github.zhuyiyi1990.hwuanote.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testReturnString")
    public String testReturnString(Model model) {
        System.out.println("执行testReturnString");
        User user = new User();
        user.setUsername("小明");
        user.setPassword("123456");
        user.setAge(18);
        model.addAttribute("user", user);
        return "success";
    }

    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行testVoid");
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
//        response.sendRedirect(request.getContextPath() + "/index.jsp");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write("json字符串");
        return;
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        System.out.println("执行testModelAndView");
        ModelAndView mv = new ModelAndView();
        User user = new User();
        user.setUsername("小强");
        user.setPassword("111111");
        user.setAge(18);
        mv.addObject("user", user);
        mv.setViewName("success");
        return mv;
    }

    @RequestMapping("/handler1")
    public String handler1(User user, Map<String, Object> map) {
        System.out.println("执行handler1");
        map.put("user", user);//放到map中的数据会自动放到request域对象中
        System.out.println(map.getClass());
        //class org.springframework.validation.support.BindingAwareModelMap
        return "success";//默认是转发
    }

    @RequestMapping("/handler2")
    public String handler2(User user, Model model) {
        System.out.println("执行handler2");
        model.addAttribute("user", user);//放到Model中的数据会自动放到request域对象中
        System.out.println(model.getClass());
        //class org.springframework.validation.support.BindingAwareModelMap
        return "success";//默认是转发
    }

    @RequestMapping("/handler3")
    public String handler3(User user, ModelMap modelMap) {
        System.out.println("执行handler3");
        System.out.println(modelMap.getClass());
        //class org.springframework.validation.support.BindingAwareModelMap
        modelMap.addAttribute("user", user);//放到ModelMap中的数据会自动放到request域对象中
        return "success";//默认是转发
    }

    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect() {
        System.out.println("执行testForwardOrRedirect");
//        return "forward:/WEB-INF/pages/success.jsp";
        return "redirect:/user/testModelAndView";
    }

}
