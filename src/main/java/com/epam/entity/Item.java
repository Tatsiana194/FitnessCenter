package com.epam.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Item extends BaseEntity implements Serializable {
    private int clientId;
    private int trainerId;
    private int price;
    private LocalDate startDate;
    private LocalDate endDate;
    private String exercises;
    private String equipment;
    private String meals;
    private boolean isApproved;

    private Item() {
    }

    private Item(Item.Builder builder) {
        clientId = builder.clientId;
        trainerId = builder.trainerId;
        price = builder.price;
        startDate = builder.startDate;
        endDate = builder.endDate;
        exercises = builder.exercises;
        equipment = builder.equipment;
        meals = builder.meals;
        isApproved = builder.isApproved;
    }

    public Item.Builder newBuilder() {
        return new Item.Builder();
    }

    public static final class Builder {
        private int clientId;
        private int trainerId;
        private int price;
        private LocalDate startDate;
        private LocalDate endDate;
        private String exercises;
        private String equipment;
        private String meals;
        private boolean isApproved;

        public Item.Builder clientId(int val) {
            clientId = val;
            return this;
        }

        public Item.Builder trainerId(int val) {
            trainerId = val;
            return this;
        }

        public Item.Builder price(int val) {
            price = val;
            return this;
        }

        public Item.Builder startDate(LocalDate val) {
            startDate = val;
            return this;
        }

        public Item.Builder endDate(LocalDate val) {
            endDate = val;
            return this;
        }

        public Item.Builder exercises(String val) {
            exercises = val;
            return this;
        }

        public Item.Builder equipment(String val) {
            equipment = val;
            return this;
        }

        public Item.Builder meals(String val) {
            meals = val;
            return this;
        }

        public Builder isApproved(boolean val) {
            isApproved = val;
            return this;
        }

        public Item build() {
            return new Item(this);
        }
    }

    @Override
    public String toString() {
        return "Item{" +
                "clientId=" + clientId +
                ", trainerId=" + trainerId +
                ", price=" + price +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", exercises='" + exercises + '\'' +
                ", equipment='" + equipment + '\'' +
                ", meals='" + meals + '\'' +
                ", isApproved=" + isApproved +
                '}';
    }
}
