package com.epam.dao;

import com.epam.db.ConnectionPool;
import com.epam.entity.Client;
import com.epam.entity.ClientStatus;
import com.epam.entity.QueryProperties;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDao implements BaseDao<Client> {
    private QueryProperties properties = QueryProperties.getInstance();
    private String selectAll = properties.getSelectAll();
    private String getById = properties.getSelectById();
    private String deleteById = properties.getDeleteById();
    private String create = properties.getCreateClient();
    private ConnectionPool connectionPool = new ConnectionPool();
    private Connection connection = connectionPool.getConnectionFromPool();
    private List<Client> clientList;
    private Client client;

    @Override
    public List<Client> findAll() {
        clientList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            final ResultSet resultSet = statement.executeQuery(selectAll);
            while (resultSet.next()) {
                Client client = new Client.Builder()
                        .userId(resultSet.getInt(2))
                        .trainerId(resultSet.getInt(4))
                        .status(ClientStatus.resolveClientStatusBiId(resultSet.getInt(3)))
                        .capacity(resultSet.getString(5))
                        .regime(resultSet.getString(6))
                        .build();
                clientList.add(client);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return clientList;
    }

    @Override
    public Client findById(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(getById)) {
            preparedStatement.setInt(1, id);
            final ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Client client = new Client.Builder()
                        .userId(resultSet.getInt(2))
                        .trainerId(resultSet.getInt(4))
                        .status(ClientStatus.resolveClientStatusBiId(resultSet.getInt(3)))
                        .capacity(resultSet.getString(5))
                        .regime(resultSet.getString(6))
                        .build();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return client;
    }

    @Override
    public boolean delete(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteById)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
          //  final ResultSet resultSet = preparedStatement.executeQuery();
          //  if (resultSet.next()) {
                System.out.println("ok");
           // }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean create(Client client) {
        ClientStatus clientStatus = client.getStatus();
        try (PreparedStatement preparedStatement = connection.prepareStatement(create)) {
            preparedStatement.setInt(1, client.getId());
            preparedStatement.setInt(2, client.getDiscount());
            preparedStatement.setInt(3, clientStatus.getId());
            final ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("ok");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }
}
