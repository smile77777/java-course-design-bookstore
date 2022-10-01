package com.bookstore.utils;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
    public static String getProperty(String propertiesName,String key)
    {
        Properties properties=new Properties();

        try {
            InputStream is=PropertiesUtil.class.getClassLoader().getResourceAsStream(propertiesName);
            properties.load(is);
            return properties.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }
}
