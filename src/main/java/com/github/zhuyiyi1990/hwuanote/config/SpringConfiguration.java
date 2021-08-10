package com.github.zhuyiyi1990.hwuanote.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"com.github.zhuyiyi1990.hwuanote"})
@Import({JdbcConfig.class, TransactionConfig.class})
@EnableTransactionManagement
public class SpringConfiguration {
}
