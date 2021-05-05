package com.epam.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReaderUtil {
    private static PropertyReaderUtil instance;
    private static final Properties properties = new Properties();

    private PropertyReaderUtil() {
    }

    public static PropertyReaderUtil getInstance() {
        if (instance == null) {
            instance = new PropertyReaderUtil();
        }
        return instance;
    }

    public Properties getProperties() {
        loadProperties();
        return properties;
    }

    public static void loadProperties() {
        final String propertiesFileName = "src/main/resources/application.properties";
        try (InputStream inputStream = new FileInputStream(propertiesFileName)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
