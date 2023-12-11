package com.pingwit.financialTrackerApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Data
@AllArgsConstructor

public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenseId;

    @NotEmpty(message="Expense name cannot be empty")
    private String expenseName;

    private BigDecimal expenseAmount;
    private Category expenseCategory;

    @Size(min=1, max=200, message = "comment size should be between {min} and {max}")
    private String expenseDescription;

    @Past(message="Date cannot be in the future")
    private Date expenseDate;

    @ManyToOne
    private User user;
    private Category category;
    private Card card;
}
