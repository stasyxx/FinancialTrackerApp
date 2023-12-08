package com.pingwit.financialTrackerApp.service;

import com.pingwit.financialTrackerApp.entity.Expense;
import com.pingwit.financialTrackerApp.repository.ExpenseRepository;
import com.pingwit.financialTrackerApp.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public BigDecimal calculateTotalExpensesByUserId(Long userId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<BigDecimal> query = cb.createQuery(BigDecimal.class);

        Root<Expense> root = query.from(Expense.class);
        query.select(cb.sum(root.get("expenseAmount")));
        query.where(cb.equal(root.get("userId"), userId));

        return entityManager.createQuery(query).getSingleResult();
    }

    public BigDecimal calculateTotalExpenseByUserIdByCategory(Long userId, Category category) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<BigDecimal> query = cb.createQuery(BigDecimal.class);

        Root<Expense> root = query.from(Expense.class);
        query.select(cb.sum(root.get("expenseAmount")));
        query.where(
                cb.equal(root.get("userId"), userId),
                cb.equal(root.get("category"), category)
        );

        return entityManager.createQuery(query).getSingleResult();
    }

    public List<Expense> getAllExpensesByUserId(List<Long> expenseIds) {
        Iterable<Expense> expenseIterable = expenseRepository.findAllById(expenseIds);
        List<Expense> expenseList = StreamSupport
                .stream(expenseIterable.spliterator(), false)
                .collect(Collectors.toList());

        for (Expense expense : expenseList) {
            System.out.println("Amount of all expenses: " + expense.getExpenseAmount());
        }

        return expenseList;
    }

    public List<Expense> getAllExpensesInMonth(Long userId, int year, int month) {
        Iterable<Expense> expenseIterable = expenseRepository.findByUserId(userId);

        List<Expense> expenseList = StreamSupport
                .stream(expenseIterable.spliterator(), false)
                .filter(expense -> {
                    Date expenseDate = expense.getExpenseDate();
                    return expenseDate != null && expenseDate.getYear() == year && expenseDate.getMonth() == month;
                    })
                    .collect(Collectors.toList());

            return expenseList;
    }

    public void addOwnExpense() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the details for the new expense:");

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Amount: ");
        BigDecimal amount = scanner.nextBigDecimal();

        System.out.print("Date (yyyy-MM-dd): ");
        String dateString = scanner.next();
        LocalDate date = LocalDate.parse(dateString);

        Expense newExpense = new Expense(expenseDescription, expenseAmount, expenseDate);

        expenseList.add(newExpense);

        System.out.println("Expense added successfully!");
    }

    public void saveExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

}