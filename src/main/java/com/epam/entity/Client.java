package com.epam.entity;

import java.io.Serializable;

public class Client extends BaseEntity implements Serializable {
    private int userId;
    private int trainerId;
    private ClientStatus status;
    private int discount;
    private String capacity;
    private String regime;

    private Client() {
    }

    private Client(Builder builder) {
        userId = builder.userId;
        trainerId = builder.trainerId;
        status = builder.status;
        discount = builder.discount;
        capacity = builder.capacity;
        regime = builder.regime;
    }

    public Builder newBuilder() {
        return new Builder();
    }

    public int getUserId() {
        return userId;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public ClientStatus getStatus() {
        return status;
    }

    public int getDiscount() {
        return discount;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getRegime() {
        return regime;
    }

    public static final class Builder {
        private int userId;
        private int trainerId;
        private ClientStatus status;
        private int discount;
        private String capacity;
        private String regime;

        public Builder userId(int val) {
            userId = val;
            return this;
        }

        public Builder trainerId(int val) {
            trainerId = val;
            return this;
        }

        public Builder status(ClientStatus val) {
            status = val;
            return this;
        }

        public Builder discount(int val) {
            discount = val;
            return this;
        }

        public Builder capacity(String val) {
            capacity = val;
            return this;
        }

        public Builder regime(String val) {
            regime = val;
            return this;
        }

        public Client build() {
            return new Client(this);
        }
    }

    @Override
    public String toString() {
        return "Client{" +
                "userId=" + userId +
                ", trainerId=" + trainerId +
                ", status='" + status + '\'' +
                ", discount=" + discount +
                ", capacity='" + capacity + '\'' +
                ", regime='" + regime + '\'' +
                '}';
    }
}
