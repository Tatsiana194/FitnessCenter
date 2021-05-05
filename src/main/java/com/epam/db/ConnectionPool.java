package com.epam.db;

import com.epam.entity.ApplicationProperties;
import com.epam.logger.JwdLogger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionPool {
    private ApplicationProperties applicationProperties = ApplicationProperties.getInstance();
    private String dburl = applicationProperties.getDbUrl();
    private String dbUser = applicationProperties.getDbUser();
    private String dbPassword = applicationProperties.getDbPassword();
    private int dbInitPoolSize = applicationProperties.getDbInitPoolSize();
    private int dbMaxPoolSize = applicationProperties.getDbMaxPoolSize();
    private static Logger logger = new JwdLogger(ConnectionPool.class.getName(), "slf4j");
    int numberOfConnection = 0;

    private List<Connection> availableConnection = new CopyOnWriteArrayList<>();

    public void init() {
        for (int i = 0; i < dbInitPoolSize; i++) {
            try (Connection connection = new ConnectionProxy(DriverManager.getConnection(dburl, dbUser, dbPassword))) {
                availableConnection.add(connection);
            } catch (SQLException exception) {
  //              logger.log(Level.WARNING, exception.getSQLState());
            }
        }
    }

    public Connection getConnectionFromPool() {
        numberOfConnection++;
        if (availableConnection.isEmpty()) {
            init();
        }
        return availableConnection.get(numberOfConnection);
    }
}
