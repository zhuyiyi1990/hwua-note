package com.github.zhuyiyi1990.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({"com.github.zhuyiyi1990"})
@Import({JdbcConfig.class})
public class SpringConfiguration {
}
