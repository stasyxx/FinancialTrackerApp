package com.pingwit.financialTrackerApp.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.criterion.IdentifierProjection;

import javax.persistence.*;

import java.util.UUID;

import static org.hibernate.criterion.Projections.id;

@Entity
@Data
@AllArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String username;

    @OneToMany
    private Expense expense;
    private Card card;

    public IdentifierProjection getId() {
        return id();
    }
}
