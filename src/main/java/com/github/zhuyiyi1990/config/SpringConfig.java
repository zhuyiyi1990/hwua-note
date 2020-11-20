package com.github.zhuyiyi1990.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"com.github.zhuyiyi1990"})
@EnableAspectJAutoProxy
public class SpringConfig {
}
