package com.epam.entity;

import java.io.Serializable;

public class Trainer extends BaseEntity implements Serializable {
    private int userId;
    private String status;

    private Trainer() {
    }

    private Trainer(Trainer.Builder builder) {
        userId = builder.userId;
        status = builder.status;
    }

    public Trainer.Builder newBuilder() {
        return new Trainer.Builder();
    }

    public static final class Builder {
        private int userId;
        private String status;

        public Trainer.Builder userId(int val) {
            userId = val;
            return this;
        }

        public Trainer.Builder status(String val) {
            status = val;
            return this;
        }

        public Trainer build() {
            return new Trainer(this);
        }
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "userId=" + userId +
                ", status='" + status + '\'' +
                '}';
    }
}
