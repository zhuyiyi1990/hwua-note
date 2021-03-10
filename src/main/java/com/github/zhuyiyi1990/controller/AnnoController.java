package com.github.zhuyiyi1990.controller;

import com.github.zhuyiyi1990.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/anno")
@SessionAttributes("msg")
public class AnnoController {

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam("name") String username) {
        System.out.println("执行testRequestParam");
        System.out.println("username:" + username);
        return "success";
    }

    /**
     * 获取请求体内容
     *
     * @param body
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println("执行testRequestBody");
        System.out.println("body:" + body);
        return "success";
    }

    /**
     * PathVariable注解
     *
     * @param id
     * @return
     */
    @RequestMapping("/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable("sid") String id) {
        System.out.println("执行testPathVariable");
        System.out.println("id:" + id);
        return "success";
    }

    /**
     * PathVariable注解,请求方式:DELETE
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/testPathVariable/{sid}", method = RequestMethod.DELETE)
    public String testPathVariable2(@PathVariable("sid") String id) {
        System.out.println("执行testPathVariable2");
        System.out.println("id:" + id);
        return "success";
    }

    /**
     * RequestHeader
     *
     * @param header
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader("Accept") String header) {
        System.out.println("执行testRequestBody");
        System.out.println(header);
        return "success";
    }

    /**
     * CookieValue
     *
     * @param cookieValue
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String cookieValue) {
        System.out.println("执行testCookieValue");
        System.out.println(cookieValue);
        return "success";
    }

    /**
     * 该方法先执行
     *
     * @param uname
     */
    @ModelAttribute
    public void showModel(String uname, Map<String, User> map) {
        System.out.println("执行showModel");
        User user = new User();
        user.setUname(uname);
        //假设以下是从数据库查询出来的信息
        user.setAge(30);
        user.setBirthday(new Date());
        map.put("user1", user);
    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("user1") User user) {
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
