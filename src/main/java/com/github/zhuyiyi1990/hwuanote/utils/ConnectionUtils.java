package com.github.zhuyiyi1990.hwuanote.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class ConnectionUtils {

    private ThreadLocal<Connection> tl = new ThreadLocal<>();

    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getThreadConnection() {
        try {
            Connection conn = tl.get();
            if (conn == null) {
                conn = dataSource.getConnection();
                tl.set(conn);
            }
            return conn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void removeConnection() {
        tl.remove();
    }

}
