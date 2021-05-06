package com.epam.entity;

import java.io.Serializable;

public enum ClientStatus implements Serializable {
    BEGINNER(1),
    CORPORATE(2),
    REGULAR(3);
    private final int id;

    ClientStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static ClientStatus resolveClientStatusBiId(int id) {
        switch (id) {
            case 1:
                return BEGINNER;
            case 2:
                return CORPORATE;
            case 3:
                return REGULAR;
        }
        return BEGINNER;
    }
}
