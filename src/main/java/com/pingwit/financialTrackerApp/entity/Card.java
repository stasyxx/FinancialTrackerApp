package com.pingwit.financialTrackerApp.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

    @Entity
    @Data
    public class Card {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long cardNumber;
        private Date dateOfExpire;
        private BigDecimal cardAmount;

        @ManyToOne
        private User user;
    }

