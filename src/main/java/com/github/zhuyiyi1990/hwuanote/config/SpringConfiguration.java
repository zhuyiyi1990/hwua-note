package com.github.zhuyiyi1990.hwuanote.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"com.github.zhuyiyi1990.hwuanote"})
@EnableAspectJAutoProxy
public class SpringConfiguration {
}
