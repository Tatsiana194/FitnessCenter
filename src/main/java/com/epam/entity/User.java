package com.epam.entity;

import java.io.Serializable;

public class User extends BaseEntity implements Serializable {
    private String login;
    private String password;

    private User() {
    }

    private User(User.Builder builder) {
        login = builder.login;
        password = builder.password;
    }

    public User.Builder newBuilder() {
        return new User.Builder();
    }

    public static final class Builder {
        private String login;
        private String password;

        public User.Builder login(String val) {
            login = val;
            return this;
        }

        public User.Builder password(String val) {
            password = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
