package com.github.zhuyiyi1990.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("helloController")
public class HelloController {
    @RequestMapping("/hello")
    public String sayHello() {
        System.out.println("Hello SpringMVC");
        return "success";
    }
}
