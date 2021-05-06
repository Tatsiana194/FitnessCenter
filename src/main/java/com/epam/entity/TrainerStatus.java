package com.epam.entity;

import java.io.Serializable;

public enum TrainerStatus implements Serializable {
    PRIVATE(1),
    GROUP(2),
    CHIEF(3);
    private final int id;

    private TrainerStatus(int id) {
        this.id = id;
    }

    public static TrainerStatus resolveClientStatusBiId(int id) {
        switch (id) {
            case 1:
                return PRIVATE;
            case 2:
                return GROUP;
            case 3:
                return CHIEF;
        }
        return PRIVATE;
    }
}
