package com.epam.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class FeedBack extends BaseEntity implements Serializable {
    private int clientId;
    private int trainerId;
    private String message;
    private LocalDate date;

    private FeedBack() {
    }

    private FeedBack(FeedBack.Builder builder) {
        clientId = builder.clientId;
        trainerId = builder.trainerId;
        message = builder.message;
        date = builder.date;
    }

    public FeedBack.Builder newBuilder() {
        return new FeedBack.Builder();
    }

    public static final class Builder {
        private int clientId;
        private int trainerId;
        private String message;
        private LocalDate date;

        public FeedBack.Builder clientId(int val) {
            clientId = val;
            return this;
        }

        public FeedBack.Builder trainerId(int val) {
            trainerId = val;
            return this;
        }

        public FeedBack.Builder message(String val) {
            message = val;
            return this;
        }

        public FeedBack.Builder date(LocalDate val) {
            date = val;
            return this;
        }

        public FeedBack build() {
            return new FeedBack(this);
        }
    }

    @Override
    public String toString() {
        return "FeedBack{" +
                "trainerId=" + trainerId +
                ", clientId=" + clientId +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }
}
