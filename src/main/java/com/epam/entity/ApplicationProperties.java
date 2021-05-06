package com.epam.entity;

import com.epam.util.PropertyReaderUtil;

import java.util.Properties;

public class ApplicationProperties {
    private String url;
    private String db;
    private String user;
    private String password;
    private int initPoolSize;
    private int maxPoolSize;
    private PropertyReaderUtil propertyReaderUtil = PropertyReaderUtil.getInstance();
    private String fileName = "src/main/resources/application.properties";
    private Properties properties = propertyReaderUtil.getProperties(fileName);
    private static ApplicationProperties instance;

    private ApplicationProperties() {
    }

    public static ApplicationProperties getInstance() {
        if (instance == null) {
            instance = new ApplicationProperties();
        }
        return instance;
    }

    public String getUrl() {
        url = properties.getProperty("url");
        return url;
    }

    public String getDb() {
        db = properties.getProperty("db");
        return db;
    }

    public String getUser() {
        user = properties.getProperty("user");
        return user;
    }

    public String getPassword() {
        password = properties.getProperty("password");
        return password;
    }

    public int getInitPoolSize() {
        initPoolSize = Integer.parseInt(properties.getProperty("initpoolsize"));
        return initPoolSize;
    }

    public int getMaxPoolSize() {
        maxPoolSize = Integer.parseInt(properties.getProperty("maxpoolsize"));
        return maxPoolSize;
    }

}
