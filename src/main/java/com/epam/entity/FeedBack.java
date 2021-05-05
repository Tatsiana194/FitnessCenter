package com.epam.entity;

import java.time.LocalDate;

public class FeedBack extends BaseEntity {
    private int trainerId;
    private int clientId;
    private String message;
    private LocalDate date;
}
