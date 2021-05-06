package com.epam;

import com.epam.dao.ClientDao;
import com.epam.entity.Client;
import com.epam.entity.ClientStatus;

public class Main {
    public static void main(String[] args) {
        ClientDao clientDao = new ClientDao();
        clientDao.findAll();
        clientDao.findById(2);
        clientDao.delete(2);
        Client client = new Client.Builder()
                .userId(2)
                .trainerId(1)
                .status(ClientStatus.BEGINNER)
                .capacity("sdas")
                .regime("assd")
                .build();
        clientDao.create(client);
    }
}
