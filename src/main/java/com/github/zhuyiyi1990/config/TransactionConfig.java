package com.github.zhuyiyi1990.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

public class TransactionConfig {

    @Bean
    public PlatformTransactionManager getTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        return transactionManager;
    }

}
