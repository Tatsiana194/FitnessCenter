package com.epam.dao;

import com.epam.db.ConnectionPool;
import com.epam.entity.Client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ClientDao implements BaseDao<Client> {
    String sql = "SELECT * FROM client";
    ConnectionPool connectionPool = new ConnectionPool();
    Connection connection = connectionPool.getConnectionFromPool();

    @Override
    public List<Client> findAll() {
        try (Statement statement = connection.createStatement()) {
            final ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public Client findById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean create(Client client) {
        return false;
    }
}
