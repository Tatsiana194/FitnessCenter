package com.epam.entity;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable {
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
