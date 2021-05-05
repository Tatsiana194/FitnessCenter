package com.epam.entity;

import java.time.LocalDate;

public class Item extends BaseEntity {
    private int clientId;
    private int trainerId;
    private int price;
    private LocalDate startDate;
    private LocalDate endDate;
    private String exercises;
    private String equipment;
    private String meals;
    private boolean isApproved;
}
