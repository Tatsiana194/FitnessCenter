package com.epam.entity;

public class Client extends BaseEntity {
    private int userId;
    private int trainerId;
    private String status;
    private int discount;
    private String capacity;
    private String regime;

    private Client(Builder builder) {
        userId = builder.userId;
        trainerId = builder.trainerId;
        status = builder.status;
        discount = builder.discount;
        capacity = builder.capacity;
        regime = builder.regime;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private int userId;
        private int trainerId;
        private String status;
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

        public Builder status(String val) {
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
    }
}
