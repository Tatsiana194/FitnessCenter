package com.epam.entity;

import java.io.Serializable;

public class CreditCard extends BaseEntity implements Serializable {
    private int clientId;
    private String name;
    private int number;
    private int month;
    private int year;
    private int cvv;

    private CreditCard() {
    }

    private CreditCard(CreditCard.Builder builder) {
        clientId = builder.clientId;
        name = builder.name;
        number = builder.number;
        month = builder.month;
        year = builder.year;
        cvv = builder.cvv;
    }

    public CreditCard.Builder newBuilder() {
        return new CreditCard.Builder();
    }

    public static final class Builder {
        private int clientId;
        private String name;
        private int number;
        private int month;
        private int year;
        private int cvv;

        public CreditCard.Builder clientId(int val) {
            clientId = val;
            return this;
        }

        public CreditCard.Builder name(String val) {
            name = val;
            return this;
        }

        public CreditCard.Builder number(int val) {
            number = val;
            return this;
        }

        public CreditCard.Builder month(int val) {
            month = val;
            return this;
        }

        public CreditCard.Builder year(int val) {
            year = val;
            return this;
        }

        public CreditCard.Builder cvv(int val) {
            cvv = val;
            return this;
        }

        public CreditCard build() {
            return new CreditCard(this);
        }
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "clientId=" + clientId +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", month=" + month +
                ", year=" + year +
                ", cvv=" + cvv +
                '}';
    }
}
