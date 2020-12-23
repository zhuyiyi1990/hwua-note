package com.github.zhuyiyi1990.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    private static Properties props;

    private static Map<String, Object> beanMap;

    static {
        try {
            props = new Properties();
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            beanMap = new HashMap<String, Object>();
            Enumeration<Object> keys = props.keys();
            while (keys.hasMoreElements()) {
                String key = keys.nextElement().toString();
                String beanName = props.getProperty(key);
                beanMap.put(key, Class.forName(beanName).newInstance());
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败!");
        }
    }

    public static Object getBean(String beanName) {
        return beanMap.get(beanName);
    }
}
