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
            Set<Object> keys = new TreeSet<>(props.keySet());
            for (Object key : keys) {
                String beanPath = props.getProperty(key.toString());
                beanMap.put(key.toString(), Class.forName(beanPath).newInstance());
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败!");
        }
    }

    public static Object getBean(String beanName) {
        return beanMap.get(beanName);
    }

}
