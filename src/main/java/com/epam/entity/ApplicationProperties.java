package com.epam.entity;

import com.epam.util.PropertyReaderUtil;

import java.util.Properties;

public class ApplicationProperties {
    private String dbUrl;
    private String dbUser;
    private String dbPassword;
    private int dbInitPoolSize;
    private int dbMaxPoolSize;
    private PropertyReaderUtil propertyReaderUtil = PropertyReaderUtil.getInstance();
    private Properties properties = propertyReaderUtil.getProperties();
    private static ApplicationProperties instance;

    private ApplicationProperties() {
    }

    public static ApplicationProperties getInstance() {
        if (instance == null) {
            instance = new ApplicationProperties();
        }
        return instance;
    }

    public String getDbUrl() {
        dbUrl = properties.getProperty("db.url");
        return dbUrl;
    }

    public String getDbUser() {
        dbUser = properties.getProperty("db.user");
        return dbUser;
    }

    public String getDbPassword() {
        dbPassword = properties.getProperty("db.password");
        return dbPassword;
    }

    public int getDbInitPoolSize() {
        dbInitPoolSize = Integer.parseInt(properties.getProperty("db.initpoolsize"));
        return dbInitPoolSize;
    }

    public int getDbMaxPoolSize() {
        dbMaxPoolSize = Integer.parseInt(properties.getProperty("db.maxpoolsize"));
        return dbMaxPoolSize;
    }

}
