package com.github.zhuyiyi1990.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("helloController")
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello() {
        System.out.println("hello SpringMVC");
        System.out.println(DigestUtils.getMd5Digest().getClass().getName());
        DigestUtils.getMd5Digest().digest();
        return "success";
    }

}
