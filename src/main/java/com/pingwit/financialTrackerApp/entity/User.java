package com.pingwit.financialTrackerApp.entity;


import lombok.Data;
import org.hibernate.criterion.IdentifierProjection;

import javax.persistence.*;

import static org.hibernate.criterion.Projections.id;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String surname;

    @OneToMany
    private Expense expense;
    private Card card;

    public IdentifierProjection getId() {
        return id();
    }
}
