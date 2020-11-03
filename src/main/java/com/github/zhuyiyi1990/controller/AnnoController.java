package com.github.zhuyiyi1990.controller;

import com.github.zhuyiyi1990.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.net.URLDecoder;
import java.util.Date;

@Controller
@RequestMapping("/anno")
@SessionAttributes("msg")//msg会拷贝一份存入Session域对象中
public class AnnoController {
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam("name") String username) {
        System.out.println("执行testRequestParam");
        System.out.println("username:" + username);
        return "success";
    }

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println("执行testRequestBody");
        System.out.println("body:" + body);
        System.out.println("username:" + body.split("&")[0].split("=")[1]);
        System.out.println(URLDecoder.decode("username:" + body.split("&")[0].split("=")[1]));
        return "success";
    }

    @RequestMapping("/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable("sid") String id) {
        System.out.println("id:" + id);
        return "success";
    }

    @RequestMapping(value = {"/testPathVariable2/{sid}"}, method = RequestMethod.DELETE)
    public String testPathVariable2(@PathVariable("sid") String id) {
        System.out.println("执行testPathVariable2");
        System.out.println(id);
        return "success";
    }

    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader("Accept") String header) {
        System.out.println("执行testRequestHeader");
        System.out.println(header);
        return "success";
    }

    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String cookie) {
        System.out.println("执行testCookieValue");
        System.out.println(cookie);
        return "success";
    }

    /**
     * 该方法先执行
     *
     * @param user
     */
    @ModelAttribute
    public void showModel(User user) {
        System.out.println("执行showModel");
        user.setBirthday(new Date());
        System.out.println(user);
    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User user) {
        System.out.println("执行testModelAttribute");
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/testSessionAttribute")
    public String testSessionAttribute(Model model) {
        System.out.println("执行testSessionAttribute");
        //底层会存储到request域对象中
        model.addAttribute("msg", "hello");
        return "success";
    }

    @RequestMapping("/getSessionAttribute")
    public String getSessionAttribute(ModelMap modelMap) {
        System.out.println("执行getSessionAttribute");
        //从session域获取值
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    @RequestMapping("/deleteSessionAttribute")
    public String deleteSessionAttribute(SessionStatus status) {
        System.out.println("执行deleteSessionAttribute");
        //从session域获取值
        status.setComplete();//操作完成,把session中的数据清除
        return "success";
    }
}
