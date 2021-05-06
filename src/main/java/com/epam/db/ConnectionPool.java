package com.epam.db;

import com.epam.entity.ApplicationProperties;
import com.epam.logger.JwdLogger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionPool {
    private ApplicationProperties applicationProperties = ApplicationProperties.getInstance();
    private String url = applicationProperties.getUrl();
    private String db = applicationProperties.getDb();
    private String user = applicationProperties.getUser();
    private String password = applicationProperties.getPassword();
    private int initPoolSize = applicationProperties.getInitPoolSize();
    private int maxPoolSize = applicationProperties.getMaxPoolSize();
    private static Logger logger = new JwdLogger(ConnectionPool.class.getName(), "slf4j");
    private int numberOfConnection = 0;

    private List<Connection> availableConnection = new ArrayList<>();

    public void init() {
        for (int i = 0; i < initPoolSize; i++) {
            try (Connection connection = new ConnectionProxy(DriverManager.getConnection(url + db, user, password))) {
                availableConnection.add(connection);
            } catch (SQLException exception) {
                logger.log(Level.WARNING, exception.getSQLState());
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
