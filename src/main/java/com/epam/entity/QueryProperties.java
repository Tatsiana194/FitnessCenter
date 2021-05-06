package com.epam.entity;

import com.epam.util.PropertyReaderUtil;

import java.util.Properties;

public class QueryProperties {
    private String selectAllClient;
    private String selectByIdClient;
    private String deleteClient;
    private String createUser;
    private String createUserInformation;
    private String createClient;
    private String createTrainer;
    private String createCreditCard;
    private String createItem;
    private String createFeedback;
    private PropertyReaderUtil propertyReaderUtil = PropertyReaderUtil.getInstance();
    private String fileName = "src/main/resources/query.properties";
    private Properties properties = propertyReaderUtil.getProperties(fileName);
    private static QueryProperties instance;

    private QueryProperties() {
    }

    public static QueryProperties getInstance() {
        if (instance == null) {
            instance = new QueryProperties();
        }
        return instance;
    }

    public String getSelectAll() {
        selectAllClient = properties.getProperty("selectAllClient");
        return selectAllClient;
    }

    public String getSelectById() {
        selectByIdClient = properties.getProperty("selectByIdClient");
        return selectByIdClient;
    }

    public String getDeleteById() {
        deleteClient = properties.getProperty("deleteClient");
        return deleteClient;
    }

    public String getCreateUser() {
        createUser = properties.getProperty("createUser");
        return createUser;
    }

    public String getCreateUserInformation() {
        createUserInformation = properties.getProperty("createUserInformation");
        return createUserInformation;
    }

    public String getCreateClient() {
        createClient = properties.getProperty("createClient");
        return createClient;
    }

    public String getCreateTrainer() {
        createTrainer = properties.getProperty("createTrainer");
        return createTrainer;
    }

    public String getCreateCreditCard() {
        createCreditCard = properties.getProperty("createCreditCard");
        return createCreditCard;
    }

    public String getCreateItem() {
        createItem = properties.getProperty("createItem");
        return createItem;
    }

    public String getCreateFeedback() {
        createFeedback = properties.getProperty("createFeedback");
        return createFeedback;
    }
}
