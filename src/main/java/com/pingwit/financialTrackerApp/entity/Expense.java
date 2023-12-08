package com.pingwit.financialTrackerApp.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenseId;
    private BigDecimal expenseAmount;
    private Category expenseCategory;
    private String expenseDescription;
    private Date expenseDate;

    @ManyToOne
    private User user;
}
