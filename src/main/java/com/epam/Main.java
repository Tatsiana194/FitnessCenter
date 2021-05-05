package com.epam;

import com.epam.dao.ClientDao;

public class Main {
    public static void main(String[] args) {
        ClientDao clientDao = new ClientDao();
        clientDao.findAll();
    }
}
