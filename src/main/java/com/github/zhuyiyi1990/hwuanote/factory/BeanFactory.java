package com.github.zhuyiyi1990.hwuanote.factory;

import java.io.InputStream;
import java.util.*;

public class BeanFactory {

    private static Properties props;

    private static Map<String, Object> beanMap;

    static {
        try {
            props = new Properties();
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            beanMap = new HashMap<>();
            List<String> keys = new ArrayList<>();
            keys.add("accountDao");
            keys.add("accountService");
            for (String key : keys) {
                String beanPath = props.getProperty(key);
                beanMap.put(key, Class.forName(beanPath).newInstance());
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败!");
        }
    }

    public static Object getBean(String beanName) {
        return beanMap.get(beanName);
    }

}
