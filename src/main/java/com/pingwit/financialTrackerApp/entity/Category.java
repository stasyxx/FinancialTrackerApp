package com.pingwit.financialTrackerApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String category;

    @OneToMany
    private Expense expense;

    @ManyToOne
    private User user;

}
